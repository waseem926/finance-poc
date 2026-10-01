package com.aifinance.poc.features.add_expense.domain

/**
 * Domain model for add_expense POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class AddExpenseItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)