package com.aifinance.poc.features.analytics.presentation

/** One-shot / user intents for [AnalyticsScreen]. */
sealed interface AnalyticsScreenUiEvent {
    data object Refresh : AnalyticsScreenUiEvent
}