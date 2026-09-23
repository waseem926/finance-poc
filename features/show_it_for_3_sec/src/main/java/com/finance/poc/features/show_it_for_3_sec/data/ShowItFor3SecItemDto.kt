package com.finance.poc.features.show_it_for_3_sec.data

/** Data-layer DTO — never expose this type to presentation. */
data class ShowItFor3SecItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)