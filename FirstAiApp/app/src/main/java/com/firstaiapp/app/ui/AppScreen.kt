package com.firstaiapp.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firstaiapp.app.ui.theme.AppTheme
import com.firstaiapp.app.ui.theme.FigmaTextStyles
import com.firstaiapp.app.ui.theme.add_expense
import com.firstaiapp.app.ui.theme.category
import com.firstaiapp.app.ui.theme.type_naturally_or_use_voice
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppScreen() {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFFFFFFF)) {
  Column(
      modifier = Modifier
          .fillMaxSize()
          .padding(horizontal = 16.dp)
          .verticalScroll(rememberScrollState()),
      verticalArrangement = Arrangement.spacedBy(8.dp),
      horizontalAlignment = Alignment.Start,
  ) {
      Card(
          modifier = Modifier.fillMaxWidth(),
          colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
      ) {
          Column(
              modifier = Modifier.fillMaxWidth().padding(12.dp),
              verticalArrangement = Arrangement.spacedBy(8.dp),
          ) {
              Column(
                  modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                  verticalArrangement = Arrangement.spacedBy(8.dp),
                  horizontalAlignment = Alignment.Start,
              ) {
                  Text(
                      text = "Add Expense",
                      style = FigmaTextStyles.add_expense,
                      color = add_expense,
                  )
                  Text(
                      text = "Type naturally or use voice",
                      style = FigmaTextStyles.type_naturally_or_use_voice,
                      color = type_naturally_or_use_voice,
                  )
              }
              OutlinedTextField(
                  value = "",
                  onValueChange = { },
                  modifier = Modifier.fillMaxWidth(),
                  placeholder = { Text(text = "500 for groceries") },
                  colors = OutlinedTextFieldDefaults.colors(
                      focusedBorderColor = Color(0xFF6200EE),
                      unfocusedBorderColor = Color(0xFF6200EE),
                  ),
              )
              Column(
                  modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                  verticalArrangement = Arrangement.spacedBy(8.dp),
                  horizontalAlignment = Alignment.Start,
              ) {
                  Text(
                      text = "Category",
                      style = FigmaTextStyles.category,
                      color = category,
                  )
                  LazyVerticalGrid(
                      columns = GridCells.Fixed(3),
                      modifier = Modifier.fillMaxWidth().height(192.dp),
                      horizontalArrangement = Arrangement.spacedBy(8.dp),
                      verticalArrangement = Arrangement.spacedBy(8.dp),
                  ) {
                      item {
                          Card(
                              modifier = Modifier.fillMaxWidth(),
                              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                          ) {
                              Column(
                                  modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 8.dp),
                                  horizontalAlignment = Alignment.CenterHorizontally,
                                  verticalArrangement = Arrangement.spacedBy(6.dp),
                              ) {
                                  Text(text = "🍔", fontSize = 24.sp)
                                  Text(
                                      text = "Food",
                                      style = MaterialTheme.typography.labelMedium,
                                      color = Color(0xFF0A0A0A),
                                  )
                              }
                          }
                      }
                      item {
                          Card(
                              modifier = Modifier.fillMaxWidth(),
                              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                          ) {
                              Column(
                                  modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 8.dp),
                                  horizontalAlignment = Alignment.CenterHorizontally,
                                  verticalArrangement = Arrangement.spacedBy(6.dp),
                              ) {
                                  Text(text = "🚗", fontSize = 24.sp)
                                  Text(
                                      text = "Transport",
                                      style = MaterialTheme.typography.labelMedium,
                                      color = Color(0xFF0A0A0A),
                                  )
                              }
                          }
                      }
                      item {
                          Card(
                              modifier = Modifier.fillMaxWidth(),
                              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                          ) {
                              Column(
                                  modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 8.dp),
                                  horizontalAlignment = Alignment.CenterHorizontally,
                                  verticalArrangement = Arrangement.spacedBy(6.dp),
                              ) {
                                  Text(text = "💡", fontSize = 24.sp)
                                  Text(
                                      text = "Bills",
                                      style = MaterialTheme.typography.labelMedium,
                                      color = Color(0xFF0A0A0A),
                                  )
                              }
                          }
                      }
                      item {
                          Card(
                              modifier = Modifier.fillMaxWidth(),
                              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                          ) {
                              Column(
                                  modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 8.dp),
                                  horizontalAlignment = Alignment.CenterHorizontally,
                                  verticalArrangement = Arrangement.spacedBy(6.dp),
                              ) {
                                  Text(text = "🛍️", fontSize = 24.sp)
                                  Text(
                                      text = "Shopping",
                                      style = MaterialTheme.typography.labelMedium,
                                      color = Color(0xFF0A0A0A),
                                  )
                              }
                          }
                      }
                      item {
                          Card(
                              modifier = Modifier.fillMaxWidth(),
                              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                          ) {
                              Column(
                                  modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 8.dp),
                                  horizontalAlignment = Alignment.CenterHorizontally,
                                  verticalArrangement = Arrangement.spacedBy(6.dp),
                              ) {
                                  Text(text = "🎬", fontSize = 24.sp)
                                  Text(
                                      text = "Entertainment",
                                      style = MaterialTheme.typography.labelMedium,
                                      color = Color(0xFF0A0A0A),
                                  )
                              }
                          }
                      }
                      item {
                          Card(
                              modifier = Modifier.fillMaxWidth(),
                              colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                          ) {
                              Column(
                                  modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 8.dp),
                                  horizontalAlignment = Alignment.CenterHorizontally,
                                  verticalArrangement = Arrangement.spacedBy(6.dp),
                              ) {
                                  Text(text = "🛒", fontSize = 24.sp)
                                  Text(
                                      text = "Groceries",
                                      style = MaterialTheme.typography.labelMedium,
                                      color = Color(0xFF0A0A0A),
                                  )
                              }
                          }
                      }
                  }
              }
              Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.spacedBy(8.dp),
                  verticalAlignment = Alignment.CenterVertically,
              ) {
                  Button(
                      modifier = Modifier.weight(1f).height(52.dp),
                      onClick = { },
                      colors = ButtonDefaults.buttonColors(
                          containerColor = Color(0xFF0A0A0A),
                          contentColor = Color(0xFFFFFFFF),
                      ),
                  ) {
                      Text(text = "Add Expense")
                  }
                  Button(
                      modifier = Modifier.weight(1f).height(52.dp),
                      onClick = { },
                      colors = ButtonDefaults.buttonColors(
                          containerColor = Color(0xFF717182),
                          contentColor = Color(0xFFFFFFFF),
                      ),
                  ) {
                      Text(text = "Continue")
                  }
              }
          }
      }
  }
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
private fun AppScreenPreview() {
    com.firstaiapp.app.ui.theme.AppTheme {
        AppScreen()
    }
}
