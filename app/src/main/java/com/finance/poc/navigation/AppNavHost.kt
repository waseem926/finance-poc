package com.finance.poc.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.finance.poc.features.splash.presentation.SplashScreen
import com.finance.poc.features.dashboard.presentation.DashboardScreen
import com.finance.poc.features.show_it_for_3_sec.presentation.ShowItFor3SecScreen

private data class Dest(val route: String, val label: String, val icon: ImageVector)

/** POC navigation host (max 3 screens). */
@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val destinations = listOf(
        Dest("splash", "Splash", Icons.Default.Home),
        Dest("dashboard", "Dashboard", Icons.Default.List),
        Dest("show_it_for_3_sec", "ShowItFor3Sec", Icons.Default.Star),
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            if (destinations.size > 1) {
                NavigationBar {
                    destinations.forEach { dest ->
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { it.route == dest.route } == true,
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
            startDestination = "splash",
            modifier = Modifier.padding(padding),
        ) {
            composable(route = "splash") { SplashScreen() }
            composable(route = "dashboard") { DashboardScreen() }
            composable(route = "show_it_for_3_sec") { ShowItFor3SecScreen() }
        }
    }
}