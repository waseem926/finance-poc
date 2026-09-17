package com.example.finance.features.transactions.domain

/**
 * Domain model for transactions POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class TransactionsItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)