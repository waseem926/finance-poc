package com.example.finance.features.budgets.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.finance.core.ui.components.PocListCard
import com.example.finance.core.ui.components.PocListScreenScaffold
import com.example.finance.core.ui.theme.AppTheme
import com.example.finance.features.budgets.domain.BudgetsItem

/** Stateful entry — collects [BudgetsViewModel] and delegates to content. */
@Composable
fun BudgetsScreen(
    viewModel: BudgetsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    BudgetsScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
    )
}

/** Stateless UI built on the shared design system (core:ui). */
@Composable
fun BudgetsScreenContent(
    state: BudgetsScreenUiState,
    onEvent: (BudgetsScreenUiEvent) -> Unit,
) {
    PocListScreenScaffold(
        title = state.title,
        subtitle = state.subtitle,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage,
        items = state.items,
        onRetry = { onEvent(BudgetsScreenUiEvent.Refresh) },
        itemKey = { it.id },
        emptyMessage = "No Budgets yet",
        emptyHint = "Track category budgets",
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
private fun BudgetsScreenPreview() {
    AppTheme {
        BudgetsScreenContent(
            state = BudgetsScreenUiState(
                isLoading = false,
                items = listOf(
                    BudgetsItem(
                        id = "1",
                        title = "Food",
                        subtitle = "$400",
                    ),
                    BudgetsItem(
                        id = "2",
                        title = "Transport",
                        subtitle = "$120",
                    ),
                    BudgetsItem(
                        id = "3",
                        title = "Fun",
                        subtitle = "$80",
                    ),
                ),
            ),
            onEvent = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BudgetsScreenEmptyPreview() {
    AppTheme {
        BudgetsScreenContent(
            state = BudgetsScreenUiState(
                isLoading = false,
                items = emptyList(),
            ),
            onEvent = {},
        )
    }
}