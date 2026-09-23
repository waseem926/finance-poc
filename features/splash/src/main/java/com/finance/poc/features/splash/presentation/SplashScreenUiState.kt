package com.finance.poc.features.splash.presentation

import com.finance.poc.features.splash.domain.SplashItem

/** Immutable UI state for [SplashScreen]. */
data class SplashScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Splash",
    val subtitle: String = "POC Splash experience derived from: Finance app , Create a splash screen, show it for 3 sec , create a dashboard screen , analysis screen",
    val items: List<SplashItem> = emptyList(),
    val errorMessage: String? = null,
)