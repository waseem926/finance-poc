package com.example.finance.features.budgets.presentation

import com.example.finance.features.budgets.domain.BudgetsItem

/** Immutable UI state for [BudgetsScreen]. */
data class BudgetsScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Budgets",
    val subtitle: String = "Track category budgets",
    val items: List<BudgetsItem> = emptyList(),
    val errorMessage: String? = null,
)