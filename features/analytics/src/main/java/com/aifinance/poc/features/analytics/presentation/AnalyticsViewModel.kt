package com.aifinance.poc.features.analytics.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.aifinance.poc.features.analytics.domain.ObserveExpenseAnalyticsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for [AnalyticsScreen].
 * Depends on use case only — never on repositories or Android framework types.
 */
@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val observeItems: ObserveExpenseAnalyticsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AnalyticsScreenUiState(isLoading = true))
    val uiState: StateFlow<AnalyticsScreenUiState> = _uiState.asStateFlow()

    init {
        onEvent(AnalyticsScreenUiEvent.Refresh)
    }

    fun onEvent(event: AnalyticsScreenUiEvent) {
        when (event) {
            AnalyticsScreenUiEvent.Refresh -> refresh()
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