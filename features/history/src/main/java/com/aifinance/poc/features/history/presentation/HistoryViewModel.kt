package com.aifinance.poc.features.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.aifinance.poc.features.history.domain.ObserveHistoryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for [HistoryScreen].
 * Depends on use case only — never on repositories or Android framework types.
 */
@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val observeItems: ObserveHistoryUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HistoryScreenUiState(isLoading = true))
    val uiState: StateFlow<HistoryScreenUiState> = _uiState.asStateFlow()

    init {
        onEvent(HistoryScreenUiEvent.Refresh)
    }

    fun onEvent(event: HistoryScreenUiEvent) {
        when (event) {
            HistoryScreenUiEvent.Refresh -> refresh()
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