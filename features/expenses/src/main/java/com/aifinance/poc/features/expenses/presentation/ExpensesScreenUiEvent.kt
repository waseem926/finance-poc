package com.aifinance.poc.features.expenses.presentation

/** One-shot / user intents for [ExpensesScreen]. */
sealed interface ExpensesScreenUiEvent {
    data object Refresh : ExpensesScreenUiEvent
}