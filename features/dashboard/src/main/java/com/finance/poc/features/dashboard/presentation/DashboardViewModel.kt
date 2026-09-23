package com.finance.poc.features.dashboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.finance.poc.features.dashboard.domain.ObserveDashboardUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for [DashboardScreen].
 * Depends on use case only — never on repositories or Android framework types.
 */
@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val observeItems: ObserveDashboardUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardScreenUiState(isLoading = true))
    val uiState: StateFlow<DashboardScreenUiState> = _uiState.asStateFlow()

    init {
        onEvent(DashboardScreenUiEvent.Refresh)
    }

    fun onEvent(event: DashboardScreenUiEvent) {
        when (event) {
            DashboardScreenUiEvent.Refresh -> refresh()
        }
    }

    private fun refresh() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            observeItems().collect { result ->
                result.fold(
                    onSuccess = { items ->
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                items = items,
                                errorMessage = null,
                            )
                        }
                    },
                    onFailure = { error ->
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                errorMessage = error.message ?: "Something went wrong",
                            )
                        }
                    },
                )
            }
        }
    }
}