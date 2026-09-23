package com.finance.poc.features.dashboard.presentation

import com.finance.poc.features.dashboard.domain.DashboardItem

/** Immutable UI state for [DashboardScreen]. */
data class DashboardScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Dashboard",
    val subtitle: String = "POC Dashboard experience derived from: Finance app , Create a splash screen, show it for 3 sec , create a dashboard screen , analysis screen",
    val items: List<DashboardItem> = emptyList(),
    val errorMessage: String? = null,
)