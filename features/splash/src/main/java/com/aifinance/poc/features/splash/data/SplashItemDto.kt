package com.aifinance.poc.features.splash.data

/** Data-layer DTO — never expose this type to presentation. */
data class SplashItemDto(
    val id: String,
    val title: String,
    val subtitle: String = "",
)