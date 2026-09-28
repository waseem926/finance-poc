package com.aifinance.poc.features.splash.presentation

import com.aifinance.poc.features.splash.domain.SplashItem

/** Immutable UI state for [SplashScreen]. */
data class SplashScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Splash",
    val subtitle: String = "POC Splash screen",
    val items: List<SplashItem> = emptyList(),
    val errorMessage: String? = null,
)