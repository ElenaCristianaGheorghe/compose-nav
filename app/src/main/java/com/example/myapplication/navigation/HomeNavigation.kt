package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.myapplication.composables.Home

fun NavController.navigateToHome() {
    this.navigate(NavDestination.Home.destination)
}

fun NavGraphBuilder.homeScreen(
    navigateToDetails: (Long) -> Unit,
    navigateToAddNewUser: () -> Unit
) {
    composable(route = NavDestination.Home.destination) {
        Home(
            navigateToDetails = navigateToDetails,
            navigateToAddNewUser = navigateToAddNewUser
        )
    }
}

