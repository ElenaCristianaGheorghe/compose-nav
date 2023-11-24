package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MyNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavDestination.Home.destination
    ) {
        homeScreen()
        detailsScreen { navController.popBackStack() }
        addNewSubScreen { navController.popBackStack() }
        subscriptionOptionsScreen { navController.popBackStack() }
        manageSubscriptionsScreen { navController.popBackStack() }
        testFragmentScreen { navController.popBackStack() }
    }
}