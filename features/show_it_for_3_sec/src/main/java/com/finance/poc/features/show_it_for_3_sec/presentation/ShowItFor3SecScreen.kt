package com.finance.poc.features.show_it_for_3_sec.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.poc.core.ui.components.PocListCard
import com.finance.poc.core.ui.components.PocListScreenScaffold
import com.finance.poc.core.ui.theme.AppTheme
import com.finance.poc.features.show_it_for_3_sec.domain.ShowItFor3SecItem

/** Stateful entry — collects [ShowItFor3SecViewModel] and delegates to content. */
@Composable
fun ShowItFor3SecScreen(
    viewModel: ShowItFor3SecViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    ShowItFor3SecScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
    )
}

/** Stateless UI built on the shared design system (core:ui). */
@Composable
fun ShowItFor3SecScreenContent(
    state: ShowItFor3SecScreenUiState,
    onEvent: (ShowItFor3SecScreenUiEvent) -> Unit,
) {
    PocListScreenScaffold(
        title = state.title,
        subtitle = state.subtitle,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage,
        items = state.items,
        onRetry = { onEvent(ShowItFor3SecScreenUiEvent.Refresh) },
        itemKey = { it.id },
        emptyMessage = "No ShowItFor3Sec yet",
        emptyHint = "POC ShowItFor3Sec experience derived from: Finance app , Create a splash screen, show it for 3 sec , create a dashboard screen , analysis screen",
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
private fun ShowItFor3SecScreenPreview() {
    AppTheme {
        ShowItFor3SecScreenContent(
            state = ShowItFor3SecScreenUiState(
                isLoading = false,
                items = listOf(
                    ShowItFor3SecItem(
                        id = "1",
                        title = "ShowItFor3Sec item 1",
                        subtitle = "ShowItFor3Sec · sample 1",
                    ),
                    ShowItFor3SecItem(
                        id = "2",
                        title = "ShowItFor3Sec item 2",
                        subtitle = "ShowItFor3Sec · sample 2",
                    ),
                    ShowItFor3SecItem(
                        id = "3",
                        title = "ShowItFor3Sec item 3",
                        subtitle = "ShowItFor3Sec · sample 3",
                    ),
                ),
            ),
            onEvent = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowItFor3SecScreenEmptyPreview() {
    AppTheme {
        ShowItFor3SecScreenContent(
            state = ShowItFor3SecScreenUiState(
                isLoading = false,
                items = emptyList(),
            ),
            onEvent = {},
        )
    }
}