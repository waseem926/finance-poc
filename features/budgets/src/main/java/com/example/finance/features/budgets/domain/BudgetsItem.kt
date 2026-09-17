package com.example.finance.features.budgets.domain

/**
 * Domain model for budgets POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class BudgetsItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)