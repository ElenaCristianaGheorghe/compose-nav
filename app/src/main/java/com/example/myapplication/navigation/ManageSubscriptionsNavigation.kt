package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.composables.ManageSubscriptions

fun NavController.navigateToManageSubscriptions(userId: Long) {
    val navDestination = NavDestination.ManageSubscriptions.destination
        .replace("{userId}", userId.toString())
    this.navigate(navDestination)
}

fun Navigator.navigateToManageSubscriptions(userId: Long) {
    val navDestination = NavDestination.ManageSubscriptions.destination
        .replace("{userId}", userId.toString())
    this.navigateTo(navDestination)
}

fun NavGraphBuilder.manageSubscriptionsScreen(
    popBackStack: () -> Unit
) {
    composable(
        route = NavDestination.ManageSubscriptions.destination,
        arguments = listOf(
            navArgument("userId") { type = NavType.LongType }
        )
    ) {
        ManageSubscriptions(
            userId = it.arguments?.getLong("userId") ?: 0,
            popBackStack = popBackStack,
        )
    }
}