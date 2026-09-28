package com.aifinance.poc.features.expenses.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.aifinance.poc.features.expenses.domain.ObserveExpensesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for [ExpensesScreen].
 * Depends on use case only — never on repositories or Android framework types.
 */
@HiltViewModel
class ExpensesViewModel @Inject constructor(
    private val observeItems: ObserveExpensesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ExpensesScreenUiState(isLoading = true))
    val uiState: StateFlow<ExpensesScreenUiState> = _uiState.asStateFlow()

    init {
        onEvent(ExpensesScreenUiEvent.Refresh)
    }

    fun onEvent(event: ExpensesScreenUiEvent) {
        when (event) {
            ExpensesScreenUiEvent.Refresh -> refresh()
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