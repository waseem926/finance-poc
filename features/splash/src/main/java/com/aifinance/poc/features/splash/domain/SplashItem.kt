package com.aifinance.poc.features.splash.domain

/**
 * Domain model for splash POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class SplashItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)