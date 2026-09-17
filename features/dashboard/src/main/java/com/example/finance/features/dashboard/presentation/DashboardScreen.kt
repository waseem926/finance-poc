package com.example.finance.features.dashboard.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.finance.core.ui.components.PocDashboardScaffold
import com.example.finance.core.ui.components.PocListCard
import com.example.finance.core.ui.components.PocMetricTile
import com.example.finance.core.ui.theme.AppTheme
import com.example.finance.features.dashboard.domain.DashboardItem

/** Stateful entry — collects [DashboardViewModel] and delegates to content. */
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    DashboardScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
    )
}

/** Stateless UI built on the shared design system (core:ui). */
@Composable
fun DashboardScreenContent(
    state: DashboardScreenUiState,
    onEvent: (DashboardScreenUiEvent) -> Unit,
) {
    val metrics = state.items.take(3)
    val activity = state.items.drop(3)
    PocDashboardScaffold(
        title = state.title,
        subtitle = state.subtitle,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage,
        metrics = metrics,
        activity = activity,
        onRetry = { onEvent(DashboardScreenUiEvent.Refresh) },
        activityKey = { it.id },
        emptyMessage = "No Dashboard yet",
        emptyHint = "See totals and quick status",
        metricContent = { item ->
            PocMetricTile(
                label = item.title,
                value = item.subtitle.ifBlank { "—" },
            )
        },
        activityContent = { item ->
            PocListCard(
                title = item.title,
                subtitle = item.subtitle,
                compact = true,
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    AppTheme {
        DashboardScreenContent(
            state = DashboardScreenUiState(
                isLoading = false,
                items = listOf(
                    DashboardItem(
                        id = "1",
                        title = "Spent this month",
                        subtitle = "$1,240",
                    ),
                    DashboardItem(
                        id = "2",
                        title = "Budget left",
                        subtitle = "$760",
                    ),
                    DashboardItem(
                        id = "3",
                        title = "Top category",
                        subtitle = "Food",
                    ),
                    DashboardItem(
                        id = "4",
                        title = "Coffee",
                        subtitle = "$4.50",
                    ),
                    DashboardItem(
                        id = "5",
                        title = "Groceries",
                        subtitle = "$62.10",
                    ),
                    DashboardItem(
                        id = "6",
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
private fun DashboardScreenEmptyPreview() {
    AppTheme {
        DashboardScreenContent(
            state = DashboardScreenUiState(
                isLoading = false,
                items = emptyList(),
            ),
            onEvent = {},
        )
    }
}