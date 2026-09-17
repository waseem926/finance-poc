package com.example.finance.features.budgets.data

/** Data-layer DTO — never expose this type to presentation. */
data class BudgetsItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)