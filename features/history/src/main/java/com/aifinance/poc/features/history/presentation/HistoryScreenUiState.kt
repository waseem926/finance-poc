package com.aifinance.poc.features.history.presentation

import com.aifinance.poc.features.history.domain.HistoryItem

/** Immutable UI state for [HistoryScreen]. */
data class HistoryScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "History",
    val subtitle: String = "Review past transactions, filter by period or category, pull to refresh.",
    val items: List<HistoryItem> = emptyList(),
    val errorMessage: String? = null,
)