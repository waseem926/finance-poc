package com.aifinance.poc.features.addexpense.presentation

import com.aifinance.poc.features.addexpense.domain.AddexpenseItem

/** Immutable UI state for [AddExpenseScreen]. */
data class AddExpenseScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Add Expense",
    val subtitle: String = "User records a new personal expense and submits it.",
    val items: List<AddexpenseItem> = emptyList(),
    val errorMessage: String? = null,
)