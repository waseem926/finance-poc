package com.finance.poc.features.show_it_for_3_sec.domain

/**
 * Domain model for show_it_for_3_sec POC rows.
 * Keep presentation and data mapping through this type — not raw Strings.
 */
data class ShowItFor3SecItem(
    val id: String,
    val title: String,
    val subtitle: String = "",
)