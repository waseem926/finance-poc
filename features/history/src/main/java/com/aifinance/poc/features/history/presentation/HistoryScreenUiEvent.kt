package com.aifinance.poc.features.history.presentation

/** One-shot / user intents for [HistoryScreen]. */
sealed interface HistoryScreenUiEvent {
    data object Refresh : HistoryScreenUiEvent
}