package com.finance.poc.features.show_it_for_3_sec.presentation

/** One-shot / user intents for [ShowItFor3SecScreen]. */
sealed interface ShowItFor3SecScreenUiEvent {
    data object Refresh : ShowItFor3SecScreenUiEvent
}