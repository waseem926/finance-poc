package com.example.finance.features.dashboard.data

/** Data-layer DTO — never expose this type to presentation. */
data class DashboardItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)