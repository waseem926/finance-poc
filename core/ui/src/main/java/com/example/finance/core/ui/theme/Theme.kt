package com.example.finance.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = AppColors.Primary,
    onPrimary = AppColors.OnPrimary,
    secondary = AppColors.Secondary,
    background = AppColors.Background,
    surface = AppColors.Surface,
    onSurface = AppColors.OnSurface,
    error = AppColors.Error,
)

private val DarkColors = darkColorScheme(
    primary = AppColors.Primary,
    onPrimary = AppColors.OnPrimary,
    secondary = AppColors.Secondary,
    background = Color(0xFF0B1220),
    surface = Color(0xFF111827),
    onSurface = Color(0xFFF8FAFC),
    error = AppColors.Error,
)

private val AppShapes = Shapes(
    small = RoundedCornerShape(AppShape.Radius / 2),
    medium = RoundedCornerShape(AppShape.Radius),
    large = RoundedCornerShape(AppShape.Radius),
)

/** Root Material 3 theme driven by design tokens. */
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val dark = isSystemInDarkTheme()
    MaterialTheme(
        colorScheme = if (dark) DarkColors else LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content,
    )
}