package com.aifinance.poc.features.analytics.presentation

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
import com.aifinance.poc.features.analytics.domain.AnalyticsItem

/** Stateful entry — collects [AnalyticsViewModel] and delegates to content. */
@Composable
fun AnalyticsScreen(
    viewModel: AnalyticsViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    AnalyticsScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
    )
}

/** Stateless UI built on the shared design system (core:ui). */
@Composable
fun AnalyticsScreenContent(
    state: AnalyticsScreenUiState,
    onEvent: (AnalyticsScreenUiEvent) -> Unit,
) {
    PocListScreenScaffold(
        title = state.title,
        subtitle = state.subtitle,
        isLoading = state.isLoading,
        errorMessage = state.errorMessage,
        items = state.items,
        onRetry = { onEvent(AnalyticsScreenUiEvent.Refresh) },
        itemKey = { it.id },
        emptyMessage = "No Analytics yet",
        emptyHint = "POC Analytics screen",
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
private fun AnalyticsScreenPreview() {
    AppTheme {
        AnalyticsScreenContent(
            state = AnalyticsScreenUiState(
                isLoading = false,
                items = listOf(
                    AnalyticsItem(
                        id = "1",
                        title = "Analytics item 1",
                        subtitle = "Analytics · sample 1",
                    ),
                    AnalyticsItem(
                        id = "2",
                        title = "Analytics item 2",
                        subtitle = "Analytics · sample 2",
                    ),
                    AnalyticsItem(
                        id = "3",
                        title = "Analytics item 3",
                        subtitle = "Analytics · sample 3",
                    ),
                ),
            ),
            onEvent = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AnalyticsScreenEmptyPreview() {
    AppTheme {
        AnalyticsScreenContent(
            state = AnalyticsScreenUiState(
                isLoading = false,
                items = emptyList(),
            ),
            onEvent = {},
        )
    }
}
