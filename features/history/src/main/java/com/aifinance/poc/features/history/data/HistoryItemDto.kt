package com.aifinance.poc.features.history.data

/** Data-layer DTO — never expose this type to presentation. */
data class HistoryItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)