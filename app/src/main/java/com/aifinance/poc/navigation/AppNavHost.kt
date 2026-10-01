package com.aifinance.poc.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import com.aifinance.poc.features.add_expense.presentation.AddExpenseScreen
import com.aifinance.poc.features.analytics.presentation.AnalyticsScreen

private data class Dest(val route: String, val label: String, val icon: ImageVector)

/** POC navigation host — splash (if any) is launch-only, not a bottom-nav tab. */
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val tabDestinations = listOf(
        Dest("add_expense", "Add Expense", Icons.Default.Home),
        Dest("analytics", "Analytics", Icons.Default.List),
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = tabDestinations.size > 1 && currentRoute != ""

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    tabDestinations.forEach { dest ->
                        NavigationBarItem(
                            selected = navBackStackEntry?.destination?.hierarchy?.any { it.route == dest.route } == true,
                            onClick = {
                                navController.navigate(dest.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { Icon(dest.icon, contentDescription = dest.label) },
                            label = { Text(dest.label) },
                        )
                    }
                }
            }
        },
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "add_expense",
            modifier = Modifier.padding(padding),
        ) {
            composable(route = "add_expense") { AddExpenseScreen() }
            composable(route = "analytics") { AnalyticsScreen() }
        }
    }
}