package com.aifinance.poc.features.analytics.domain

/**
 * Domain model for analytics POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class AnalyticsItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)