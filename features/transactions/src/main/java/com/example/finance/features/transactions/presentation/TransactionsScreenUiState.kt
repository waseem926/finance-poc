package com.example.finance.features.transactions.presentation

import com.example.finance.features.transactions.domain.TransactionsItem

/** Immutable UI state for [TransactionsScreen]. */
data class TransactionsScreenUiState(
    val isLoading: Boolean = false,
    val title: String = "Transactions",
    val subtitle: String = "Browse recent expenses",
    val items: List<TransactionsItem> = emptyList(),
    val errorMessage: String? = null,
)