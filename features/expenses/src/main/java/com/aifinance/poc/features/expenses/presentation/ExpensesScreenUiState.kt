package com.aifinance.poc.features.expenses.presentation

import com.aifinance.poc.features.expenses.domain.ExpensesItem

/** Immutable UI state for [ExpensesScreen]. */
data class ExpensesScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Expenses",
    val subtitle: String = "POC Expenses screen",
    val items: List<ExpensesItem> = emptyList(),
    val errorMessage: String? = null,
)