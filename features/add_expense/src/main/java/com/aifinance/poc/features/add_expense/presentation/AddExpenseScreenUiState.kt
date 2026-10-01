package com.aifinance.poc.features.add_expense.presentation

import com.aifinance.poc.features.add_expense.domain.AddExpenseItem

/** Immutable UI state for [AddExpenseScreen]. */
data class AddExpenseScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Add expense",
    val subtitle: String = "Enter and save a new expense",
    val items: List<AddExpenseItem> = emptyList(),
    val errorMessage: String? = null,
)