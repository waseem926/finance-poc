package com.aifinance.poc.features.history.domain

/**
 * Domain model for history POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class HistoryItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)