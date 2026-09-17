package com.example.finance.features.transactions.presentation

/** One-shot / user intents for [TransactionsScreen]. */
sealed interface TransactionsScreenUiEvent {
    data object Refresh : TransactionsScreenUiEvent
}