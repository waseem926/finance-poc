package com.aifinance.poc.features.expenses.domain

/**
 * Domain model for expenses POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class ExpensesItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)