package com.example.finance.features.budgets.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.finance.features.budgets.domain.ObserveBudgetsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for [BudgetsScreen].
 * Depends on use case only — never on repositories or Android framework types.
 */
@HiltViewModel
class BudgetsViewModel @Inject constructor(
    private val observeItems: ObserveBudgetsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(BudgetsScreenUiState(isLoading = true))
    val uiState: StateFlow<BudgetsScreenUiState> = _uiState.asStateFlow()

    init {
        onEvent(BudgetsScreenUiEvent.Refresh)
    }

    fun onEvent(event: BudgetsScreenUiEvent) {
        when (event) {
            BudgetsScreenUiEvent.Refresh -> refresh()
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