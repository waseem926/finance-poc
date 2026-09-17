package com.example.finance.features.dashboard.presentation

import com.example.finance.features.dashboard.domain.DashboardItem

/** Immutable UI state for [DashboardScreen]. */
data class DashboardScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Dashboard",
    val subtitle: String = "See totals and quick status",
    val items: List<DashboardItem> = emptyList(),
    val errorMessage: String? = null,
)