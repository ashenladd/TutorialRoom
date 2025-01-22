package com.example.tutorialroom.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tutorialroom.core.routes.AppRoutes
import com.example.tutorialroom.ui.home.HomeScreen
import com.example.tutorialroom.ui.splash.SplashScreen

// Main Navigation Component
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.Splash.route
    ) {
        // Splash Screen
        composable(AppRoutes.Splash.route) {
            SplashScreen(navController)
        }

        // Home Screen
        composable(AppRoutes.Home.route) {
            HomeScreen(navController)
        }
    }
}