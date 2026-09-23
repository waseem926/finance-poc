package com.finance.poc.features.show_it_for_3_sec.presentation

import com.finance.poc.features.show_it_for_3_sec.domain.ShowItFor3SecItem

/** Immutable UI state for [ShowItFor3SecScreen]. */
data class ShowItFor3SecScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "ShowItFor3Sec",
    val subtitle: String = "POC ShowItFor3Sec experience derived from: Finance app , Create a splash screen, show it for 3 sec , create a dashboard screen , analysis screen",
    val items: List<ShowItFor3SecItem> = emptyList(),
    val errorMessage: String? = null,
)