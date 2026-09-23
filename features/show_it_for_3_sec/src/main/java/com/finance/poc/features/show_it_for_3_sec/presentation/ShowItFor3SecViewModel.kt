package com.finance.poc.features.show_it_for_3_sec.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.finance.poc.features.show_it_for_3_sec.domain.ObserveShowItFor3SecUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for [ShowItFor3SecScreen].
 * Depends on use case only — never on repositories or Android framework types.
 */
@HiltViewModel
class ShowItFor3SecViewModel @Inject constructor(
    private val observeItems: ObserveShowItFor3SecUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ShowItFor3SecScreenUiState(isLoading = true))
    val uiState: StateFlow<ShowItFor3SecScreenUiState> = _uiState.asStateFlow()

    init {
        onEvent(ShowItFor3SecScreenUiEvent.Refresh)
    }

    fun onEvent(event: ShowItFor3SecScreenUiEvent) {
        when (event) {
            ShowItFor3SecScreenUiEvent.Refresh -> refresh()
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