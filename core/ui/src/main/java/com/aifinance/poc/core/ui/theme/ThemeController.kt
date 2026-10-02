package com.aifinance.poc.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Session dark-mode controller.
 * darkOverride null = follow system; after toggle it is explicit true/false.
 */
class ThemeController(initialDark: Boolean? = null) {
    private val _darkOverride = mutableStateOf(initialDark)
    var darkOverride: Boolean?
        get() = _darkOverride.value
        set(value) {
            _darkOverride.value = value
        }

    fun resolve(systemDark: Boolean): Boolean = darkOverride ?: systemDark

    fun toggle(systemDark: Boolean) {
        val currentlyDark = darkOverride ?: systemDark
        darkOverride = !currentlyDark
    }
}

val LocalThemeController = staticCompositionLocalOf<ThemeController?> { null }

@Composable
fun rememberThemeController(): ThemeController = remember { ThemeController() }

@Composable
fun ProvideThemeController(
    controller: ThemeController,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalThemeController provides controller) {
        content()
    }
}

@Composable
fun themeIsDark(controller: ThemeController): Boolean {
    // Read state so recomposition runs when toggle flips.
    val override = controller.darkOverride
    return override ?: isSystemInDarkTheme()
}