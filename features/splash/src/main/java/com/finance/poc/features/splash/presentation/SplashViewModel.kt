package com.finance.poc.features.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.finance.poc.features.splash.domain.ObserveSplashUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for [SplashScreen].
 * Depends on use case only — never on repositories or Android framework types.
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val observeItems: ObserveSplashUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(SplashScreenUiState(isLoading = true))
    val uiState: StateFlow<SplashScreenUiState> = _uiState.asStateFlow()

    init {
        onEvent(SplashScreenUiEvent.Refresh)
    }

    fun onEvent(event: SplashScreenUiEvent) {
        when (event) {
            SplashScreenUiEvent.Refresh -> refresh()
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