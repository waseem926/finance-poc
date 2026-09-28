package com.aifinance.poc.features.dashboard.presentation

/** One-shot / user intents for [DashboardScreen]. */
sealed interface DashboardScreenUiEvent {
    data object Refresh : DashboardScreenUiEvent
}