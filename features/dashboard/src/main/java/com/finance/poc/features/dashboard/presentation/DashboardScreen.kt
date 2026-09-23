package com.finance.poc.features.dashboard.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.finance.poc.core.ui.components.PocDashboardScaffold
import com.finance.poc.core.ui.components.PocListCard
import com.finance.poc.core.ui.components.PocMetricTile
import com.finance.poc.core.ui.theme.AppTheme
import com.finance.poc.features.dashboard.domain.DashboardItem

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
        emptyHint = "POC Dashboard experience derived from: Finance app , Create a splash screen, show it for 3 sec , create a dashboard screen , analysis screen",
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
                        title = "Dashboard item 1",
                        subtitle = "Dashboard · sample 1",
                    ),
                    DashboardItem(
                        id = "2",
                        title = "Dashboard item 2",
                        subtitle = "Dashboard · sample 2",
                    ),
                    DashboardItem(
                        id = "3",
                        title = "Dashboard item 3",
                        subtitle = "Dashboard · sample 3",
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