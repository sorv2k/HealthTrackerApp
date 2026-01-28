package com.sourav.healthtracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sourav.healthtracker.ui.screens.DashboardScreen
import com.sourav.healthtracker.ui.screens.StepsScreen
import com.sourav.healthtracker.ui.screens.WaterScreen
import com.sourav.healthtracker.ui.screens.SleepScreen
import com.sourav.healthtracker.ui.viewmodel.HealthViewModel

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object Steps : Screen("steps")
    object Water : Screen("water")
    object Sleep : Screen("sleep")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: HealthViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ) {
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                viewModel = viewModel,
                onNavigateToSteps = { navController.navigate(Screen.Steps.route) },
                onNavigateToWater = { navController.navigate(Screen.Water.route) },
                onNavigateToSleep = { navController.navigate(Screen.Sleep.route) }
            )
        }

        composable(Screen.Steps.route) {
            StepsScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Water.route) {
            WaterScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Sleep.route) {
            SleepScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}