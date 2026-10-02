package com.aifinance.poc.features.addexpense.data

/** Data-layer DTO — never expose this type to presentation. */
data class AddexpenseItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)