package com.example.finance.features.transactions.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.finance.core.ui.components.PocListCard
import com.example.finance.core.ui.components.PocListScreenScaffold
import com.example.finance.core.ui.theme.AppTheme
import com.example.finance.features.transactions.domain.TransactionsItem

/** Stateful entry — collects [TransactionsViewModel] and delegates to content. */
@Composable
fun TransactionsScreen(
    viewModel: TransactionsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    TransactionsScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
    )
}

/** Stateless UI built on the shared design system (core:ui). */
@Composable
fun TransactionsScreenContent(
    state: TransactionsScreenUiState,
    onEvent: (TransactionsScreenUiEvent) -> Unit,
) {
    PocListScreenScaffold(
        title = state.title,
        subtitle = state.subtitle,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage,
        items = state.items,
        onRetry = { onEvent(TransactionsScreenUiEvent.Refresh) },
        itemKey = { it.id },
        emptyMessage = "No Transactions yet",
        emptyHint = "Browse recent expenses",
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
private fun TransactionsScreenPreview() {
    AppTheme {
        TransactionsScreenContent(
            state = TransactionsScreenUiState(
                isLoading = false,
                items = listOf(
                    TransactionsItem(
                        id = "1",
                        title = "Coffee",
                        subtitle = "$4.50",
                    ),
                    TransactionsItem(
                        id = "2",
                        title = "Groceries",
                        subtitle = "$62.10",
                    ),
                    TransactionsItem(
                        id = "3",
                        title = "Metro",
                        subtitle = "$2.75",
                    ),
                ),
            ),
            onEvent = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TransactionsScreenEmptyPreview() {
    AppTheme {
        TransactionsScreenContent(
            state = TransactionsScreenUiState(
                isLoading = false,
                items = emptyList(),
            ),
            onEvent = {},
        )
    }
}