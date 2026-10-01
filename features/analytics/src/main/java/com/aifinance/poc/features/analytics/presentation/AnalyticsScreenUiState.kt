package com.aifinance.poc.features.analytics.presentation

import com.aifinance.poc.features.analytics.domain.AnalyticsItem

/** Immutable UI state for [AnalyticsScreen]. */
data class AnalyticsScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Analytics",
    val subtitle: String = "Review spending summary and tap to filter by category or open Add Expense",
    val items: List<AnalyticsItem> = emptyList(),
    val errorMessage: String? = null,
)