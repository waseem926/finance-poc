package com.example.finance.features.transactions.data

/** Data-layer DTO — never expose this type to presentation. */
data class TransactionsItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)