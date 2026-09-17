package com.example.finance.features.transactions.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.finance.features.transactions.domain.ObserveTransactionsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for [TransactionsScreen].
 * Depends on use case only — never on repositories or Android framework types.
 */
@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val observeItems: ObserveTransactionsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(TransactionsScreenUiState(isLoading = true))
    val uiState: StateFlow<TransactionsScreenUiState> = _uiState.asStateFlow()

    init {
        onEvent(TransactionsScreenUiEvent.Refresh)
    }

    fun onEvent(event: TransactionsScreenUiEvent) {
        when (event) {
            TransactionsScreenUiEvent.Refresh -> refresh()
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