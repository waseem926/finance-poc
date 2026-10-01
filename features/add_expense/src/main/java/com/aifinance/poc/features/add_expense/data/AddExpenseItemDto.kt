package com.aifinance.poc.features.add_expense.data

/** Data-layer DTO — never expose this type to presentation. */
data class AddExpenseItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)