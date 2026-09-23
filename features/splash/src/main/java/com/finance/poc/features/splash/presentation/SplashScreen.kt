package com.finance.poc.features.splash.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.poc.core.ui.components.PocListCard
import com.finance.poc.core.ui.components.PocListScreenScaffold
import com.finance.poc.core.ui.theme.AppTheme
import com.finance.poc.features.splash.domain.SplashItem

/** Stateful entry — collects [SplashViewModel] and delegates to content. */
@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    SplashScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
    )
}

/** Stateless UI built on the shared design system (core:ui). */
@Composable
fun SplashScreenContent(
    state: SplashScreenUiState,
    onEvent: (SplashScreenUiEvent) -> Unit,
) {
    PocListScreenScaffold(
        title = state.title,
        subtitle = state.subtitle,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage,
        items = state.items,
        onRetry = { onEvent(SplashScreenUiEvent.Refresh) },
        itemKey = { it.id },
        emptyMessage = "No Splash yet",
        emptyHint = "POC Splash experience derived from: Finance app , Create a splash screen, show it for 3 sec , create a dashboard screen , analysis screen",
    ) { item ->
        PocListCard(
            title = item.title,
            subtitle = item.subtitle,
            compact = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    AppTheme {
        SplashScreenContent(
            state = SplashScreenUiState(
                isLoading = false,
                items = listOf(
                    SplashItem(
                        id = "1",
                        title = "App logo",
                        subtitle = "Splash · sample 1",
                    ),
                    SplashItem(
                        id = "2",
                        title = "Loading…",
                        subtitle = "Splash · sample 2",
                    ),
                    SplashItem(
                        id = "3",
                        title = "Continue",
                        subtitle = "Splash · sample 3",
                    ),
                ),
            ),
            onEvent = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenEmptyPreview() {
    AppTheme {
        SplashScreenContent(
            state = SplashScreenUiState(
                isLoading = false,
                items = emptyList(),
            ),
            onEvent = {},
        )
    }
}