package com.aifinance.poc.features.expenses.data

/** Data-layer DTO — never expose this type to presentation. */
data class ExpensesItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)