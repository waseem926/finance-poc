package com.example.finance.features.dashboard.presentation

/** One-shot / user intents for [DashboardScreen]. */
sealed interface DashboardScreenUiEvent {
    data object Refresh : DashboardScreenUiEvent
}