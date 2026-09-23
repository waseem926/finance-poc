package com.finance.poc.core.ui.theme

import androidx.compose.ui.unit.dp

/**
 * Spacing + shape tokens (base unit = 8dp from design plan).
 * Prefer these over hardcoded paddings in feature screens.
 */
object AppSpacing {
    val Unit = 8.dp
    val Xxs = Unit / 2
    val Xs = Unit
    val Sm = Unit * 2
    val Md = Unit * 3
    val Lg = Unit * 4
    val Xl = Unit * 6
}

object AppShape {
    val Radius = 16.dp
}