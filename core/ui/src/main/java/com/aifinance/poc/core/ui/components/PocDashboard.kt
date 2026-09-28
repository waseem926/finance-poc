package com.aifinance.poc.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.aifinance.poc.core.ui.theme.AppShape
import com.aifinance.poc.core.ui.theme.AppSpacing

/** Dashboard metric tile — small label + prominent value. */
@Composable
fun PocMetricTile(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(AppShape.Radius),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = AppSpacing.Xxs),
    ) {
        Column(modifier = Modifier.padding(AppSpacing.Sm)) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = AppSpacing.Xxs),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

/** Dashboard: metric tiles + recent activity (no duplicated summary strip). */
@Composable
fun <T> PocDashboardScaffold(
    title: String,
    subtitle: String,
    isLoading: Boolean,
    errorMessage: String?,
    metrics: List<T>,
    activity: List<T>,
    onRetry: () -> Unit,
    activityKey: (T) -> Any,
    emptyMessage: String = "No dashboard data yet",
    emptyHint: String = "",
    metricContent: @Composable (T) -> Unit,
    activityContent: @Composable (T) -> Unit,
) {
    Scaffold(topBar = { PocTopBar(title = title) }) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            when {
                isLoading -> PocLoading()
                errorMessage != null -> PocError(message = errorMessage ?: "", onRetry = onRetry)
                metrics.isEmpty() && activity.isEmpty() -> {
                    PocEmpty(message = emptyMessage, hint = emptyHint)
                }
                else -> {
                    LazyColumn(
                        contentPadding = PaddingValues(AppSpacing.Sm),
                        verticalArrangement = Arrangement.spacedBy(AppSpacing.Sm),
                    ) {
                        item {
                            Text(
                                text = subtitle,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                        if (metrics.isNotEmpty()) {
                            item {
                                Text(
                                    text = "This month",
                                    style = MaterialTheme.typography.titleSmall,
                                    modifier = Modifier.padding(top = AppSpacing.Xs),
                                )
                            }
                            item {
                                Column(verticalArrangement = Arrangement.spacedBy(AppSpacing.Xs)) {
                                    metrics.chunked(2).forEach { row ->
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.spacedBy(AppSpacing.Xs),
                                        ) {
                                            row.forEach { metric ->
                                                Box(modifier = Modifier.weight(1f)) { metricContent(metric) }
                                            }
                                            if (row.size == 1) {
                                                Box(modifier = Modifier.weight(1f))
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        item {
                            Text(
                                text = "Recent activity",
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier.padding(top = AppSpacing.Xs),
                            )
                        }
                        if (activity.isEmpty()) {
                            item {
                                Text(
                                    text = "No recent activity yet",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                )
                            }
                        } else {
                            items(activity, key = activityKey) { row -> activityContent(row) }
                        }
                    }
                }
            }
        }
    }
}