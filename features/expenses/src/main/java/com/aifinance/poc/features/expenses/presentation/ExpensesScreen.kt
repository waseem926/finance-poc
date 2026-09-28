package com.aifinance.poc.features.expenses.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aifinance.poc.core.ui.components.PocListCard
import com.aifinance.poc.core.ui.components.PocListScreenScaffold
import com.aifinance.poc.core.ui.theme.AppSpacing
import com.aifinance.poc.core.ui.theme.AppTheme
import com.aifinance.poc.features.expenses.domain.ExpensesItem

/** Stateful entry — collects [ExpensesViewModel] and delegates to content. */
@Composable
fun ExpensesScreen(
    viewModel: ExpensesViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    ExpensesScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
    )
}

/** Stateless UI built on the shared design system (core:ui). */
@Composable
fun ExpensesScreenContent(
    state: ExpensesScreenUiState,
    onEvent: (ExpensesScreenUiEvent) -> Unit,
) {
    PocListScreenScaffold(
        title = state.title,
        subtitle = state.subtitle,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage,
        items = state.items,
        onRetry = { onEvent(ExpensesScreenUiEvent.Refresh) },
        itemKey = { it.id },
        emptyMessage = "No Expenses yet",
        emptyHint = "POC Expenses screen",
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
private fun ExpensesScreenPreview() {
    AppTheme {
        ExpensesScreenContent(
            state = ExpensesScreenUiState(
                isLoading = false,
                items = listOf(
                    ExpensesItem(
                        id = "1",
                        title = "Expenses item 1",
                        subtitle = "Expenses · sample 1",
                    ),
                    ExpensesItem(
                        id = "2",
                        title = "Expenses item 2",
                        subtitle = "Expenses · sample 2",
                    ),
                    ExpensesItem(
                        id = "3",
                        title = "Expenses item 3",
                        subtitle = "Expenses · sample 3",
                    ),
                ),
            ),
            onEvent = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ExpensesScreenEmptyPreview() {
    AppTheme {
        ExpensesScreenContent(
            state = ExpensesScreenUiState(
                isLoading = false,
                items = emptyList(),
            ),
            onEvent = {},
        )
    }
}
