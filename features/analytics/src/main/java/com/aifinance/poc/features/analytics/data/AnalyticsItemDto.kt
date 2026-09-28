package com.aifinance.poc.features.analytics.data

/** Data-layer DTO — never expose this type to presentation. */
data class AnalyticsItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)