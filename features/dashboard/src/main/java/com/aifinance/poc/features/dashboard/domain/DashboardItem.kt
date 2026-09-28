package com.aifinance.poc.features.dashboard.domain

/**
 * Domain model for dashboard POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class DashboardItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)