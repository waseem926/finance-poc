package com.aifinance.poc.features.add_expense.presentation

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
fun AddExpenseScreen(
    viewModel: AddExpenseViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    AddExpenseScreenContent(
        state = state,
        onEvent = viewModel::onEvent,
    )
}

@Composable
fun AddExpenseScreenContent(
    state: AddExpenseScreenUiState,
    onEvent: (AddExpenseScreenUiEvent) -> Unit,
) {
    val emptyMessage = "No recent expenses yet"
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
                    text = "Add Expense",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = state.subtitle.ifBlank { "Type naturally or use voice" },
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

            PocListCard(
                title = "Recent",
                subtitle = "Groceries · 500 PKR",
                compact = true,
            )
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEEF0)),
                elevation = CardDefaults.cardElevation(0.dp),
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    OutlinedTextField(
                        value = "500 for groceries",
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                        ),
                    )
                    Text(
                        text = "CATEGORY",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.SemiBold,
                    )
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(Color(0xFFF3E8FF), RoundedCornerShape(16.dp))
                        .border(1.5.dp, Color(0xFFA855F7), RoundedCornerShape(16.dp))
                        .clickable { }
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                ) {
                    Text(text = "🍔", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        text = "Food",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF717182),
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(Color(0xFFF5F5F7), RoundedCornerShape(16.dp))
                        .clickable { }
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                ) {
                    Text(text = "🚗", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        text = "Transport",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF717182),
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(Color(0xFFF5F5F7), RoundedCornerShape(16.dp))
                        .clickable { }
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                ) {
                    Text(text = "💡", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        text = "Bills",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF717182),
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(Color(0xFFF5F5F7), RoundedCornerShape(16.dp))
                        .clickable { }
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                ) {
                    Text(text = "🛍️", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        text = "Shopping",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF717182),
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(Color(0xFFF5F5F7), RoundedCornerShape(16.dp))
                        .clickable { }
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                ) {
                    Text(text = "🎬", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        text = "Entertainment",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF717182),
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(Color(0xFFF5F5F7), RoundedCornerShape(16.dp))
                        .clickable { }
                        .padding(vertical = 12.dp, horizontal = 8.dp),
                ) {
                    Text(text = "🛒", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        text = "Groceries",
                        style = MaterialTheme.typography.labelMedium,
                        color = Color(0xFF717182),
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
            }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Button(
                            onClick = { onEvent(AddExpenseScreenUiEvent.Refresh) },
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp),
                            shape = RoundedCornerShape(18.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE4E4E7),
                                contentColor = MaterialTheme.colorScheme.onSurface,
                            ),
                        ) {
                            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Add",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Add Expense", fontWeight = FontWeight.SemiBold)
                        }
}
}
}
}
}
}
