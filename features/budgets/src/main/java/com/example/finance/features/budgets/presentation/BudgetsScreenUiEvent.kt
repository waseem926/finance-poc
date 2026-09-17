package com.example.finance.features.budgets.presentation

/** One-shot / user intents for [BudgetsScreen]. */
sealed interface BudgetsScreenUiEvent {
    data object Refresh : BudgetsScreenUiEvent
}