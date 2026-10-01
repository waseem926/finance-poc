package com.aifinance.poc.features.analytics.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aifinance.poc.core.ui.components.PocListCard
import com.aifinance.poc.core.ui.components.PocMetricTile
import com.aifinance.poc.core.ui.theme.AppTheme


/**
 * Design-aware screen generated from Figma ScreenIR
 * (deterministic IR→Compose path — uses core:ui components).
 */
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

@Composable
fun AnalyticsScreenContent(
    state: AnalyticsScreenUiState,
    onEvent: (AnalyticsScreenUiEvent) -> Unit,
) {
    val emptyMessage = "No analytics data yet"
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF7F7F8),
    ) {
        if (state.isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            return@Surface
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Analytics",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = state.subtitle.ifBlank { "Your spending insights" },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp),
                )
            }
            Icon(
                imageVector = Icons.Outlined.DarkMode,
                contentDescription = "Theme",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE8E8EA), RoundedCornerShape(16.dp))
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                listOf("Week", "Month", "Year").forEachIndexed { index, label ->
                    val selected = index == 1
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                if (selected) Color.White else Color.Transparent,
                                RoundedCornerShape(12.dp),
                            )
                            .padding(vertical = 10.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = label,
                            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                PocMetricTile(label = "Total Spent", value = "8,500 PKR", modifier = Modifier.weight(1f))
                PocMetricTile(label = "Avg Daily", value = "1,214 PKR", modifier = Modifier.weight(1f))
                PocMetricTile(label = "Transactions", value = "5", modifier = Modifier.weight(1f))
            }
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Spending Trend", fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(12.dp))
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp),
                    ) {
                        val pts = listOf(0.15f, 0.45f, 0.35f, 0.7f, 0.55f, 0.85f, 0.4f)
                        val path = Path()
                        pts.forEachIndexed { i, yNorm ->
                            val x = size.width * (i / (pts.size - 1f))
                            val y = size.height * (1f - yNorm)
                            if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
                        }
                        drawPath(
                            path = path,
                            color = Color(0xFF2563EB),
                            style = Stroke(width = 6f, cap = StrokeCap.Round),
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        listOf("1", "10", "20", "30").forEach {
                            Text(it, style = MaterialTheme.typography.labelSmall, color = Color(0xFF71717A))
                        }
                    }
                }
            }

            if (state.items.isEmpty()) {
                Text(
                    text = emptyMessage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            } else {
                state.items.take(3).forEach { item ->
                    PocListCard(
                        title = item.title,
                        subtitle = item.subtitle,
                        compact = true,
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AnalyticsScreenPreview() {
    AppTheme {
        AnalyticsScreenContent(
            state = AnalyticsScreenUiState(
                title = "Analytics",
                subtitle = "View spending by category and period comparison",
            ),
            onEvent = {},
        )
    }
}
