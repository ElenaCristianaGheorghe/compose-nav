package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun MyNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavDestination.Home.destination
    ) {
        homeScreen(
            navigateToDetails = navController::navigateToDetails,
            navigateToAddNewUser = navController::navigateToAddNewUser
        )
        detailsScreen(
            popBackStack = navController::popBackStack,
            navigateToSubscriptionOptions = navController::navigateToSubscriptionOptions,
            navigateToManageSubscriptions = navController::navigateToManageSubscriptions
        )
        addNewUserScreen { navController.popBackStack() }
        subscriptionOptionsScreen { navController.popBackStack() }
        manageSubscriptionsScreen { navController.popBackStack() }
    }
}