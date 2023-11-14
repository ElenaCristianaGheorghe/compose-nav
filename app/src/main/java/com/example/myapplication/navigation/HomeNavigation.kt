package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.myapplication.composables.Home

fun NavController.navigateToHome() {
    this.navigate(NavDestination.Home.destination)
}

fun Navigator.navigateToHome() {
    this.navigateTo(NavDestination.Home.destination)
}

fun NavGraphBuilder.homeScreen(
) {
    composable(route = NavDestination.Home.destination) {
        Home()
    }
}

