package com.aifinance.poc.features.dashboard.presentation

import com.aifinance.poc.features.dashboard.domain.DashboardItem

/** Immutable UI state for [DashboardScreen]. */
data class DashboardScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Dashboard",
    val subtitle: String = "POC Dashboard screen",
    val items: List<DashboardItem> = emptyList(),
    val errorMessage: String? = null,
)