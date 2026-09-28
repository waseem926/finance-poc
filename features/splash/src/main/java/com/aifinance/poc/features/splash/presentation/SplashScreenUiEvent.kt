package com.aifinance.poc.features.splash.presentation

/** One-shot / user intents for [SplashScreen]. */
sealed interface SplashScreenUiEvent {
    data object Refresh : SplashScreenUiEvent
}