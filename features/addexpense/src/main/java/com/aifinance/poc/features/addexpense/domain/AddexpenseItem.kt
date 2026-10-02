package com.aifinance.poc.features.addexpense.domain

/**
 * Domain model for addexpense POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class AddexpenseItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)