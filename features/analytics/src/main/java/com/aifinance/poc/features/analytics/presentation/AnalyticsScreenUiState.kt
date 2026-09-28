package com.aifinance.poc.features.analytics.presentation

import com.aifinance.poc.features.analytics.domain.AnalyticsItem

/** Immutable UI state for [AnalyticsScreen]. */
data class AnalyticsScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Analytics",
    val subtitle: String = "POC Analytics screen",
    val items: List<AnalyticsItem> = emptyList(),
    val errorMessage: String? = null,
)