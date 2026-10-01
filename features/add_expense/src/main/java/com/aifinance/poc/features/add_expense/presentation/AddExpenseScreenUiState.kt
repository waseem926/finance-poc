package com.aifinance.poc.features.add_expense.presentation

import com.aifinance.poc.features.add_expense.domain.AddExpenseItem

/** Immutable UI state for [AddExpenseScreen]. */
data class AddExpenseScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Add Expense",
    val subtitle: String = "Create a new expense and optionally open Analytics after save",
    val items: List<AddExpenseItem> = emptyList(),
    val errorMessage: String? = null,
)