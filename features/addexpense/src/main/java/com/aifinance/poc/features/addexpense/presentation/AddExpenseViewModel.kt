package com.aifinance.poc.features.addexpense.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.aifinance.poc.features.addexpense.domain.GetExpenseCategoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for [AddExpenseScreen].
 * Depends on use case only — never on repositories or Android framework types.
 */
@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val observeItems: GetExpenseCategoriesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddExpenseScreenUiState(isLoading = true))
    val uiState: StateFlow<AddExpenseScreenUiState> = _uiState.asStateFlow()

    init {
        onEvent(AddExpenseScreenUiEvent.Refresh)
    }

    fun onEvent(event: AddExpenseScreenUiEvent) {
        when (event) {
            AddExpenseScreenUiEvent.Refresh -> refresh()
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