package com.aifinance.poc.features.addexpense.presentation

/** One-shot / user intents for [AddExpenseScreen]. */
sealed interface AddExpenseScreenUiEvent {
    data object Refresh : AddExpenseScreenUiEvent
}