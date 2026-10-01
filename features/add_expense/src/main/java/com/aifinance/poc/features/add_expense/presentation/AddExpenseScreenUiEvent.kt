package com.aifinance.poc.features.add_expense.presentation

/** One-shot / user intents for [AddExpenseScreen]. */
sealed interface AddExpenseScreenUiEvent {
    data object Refresh : AddExpenseScreenUiEvent
}