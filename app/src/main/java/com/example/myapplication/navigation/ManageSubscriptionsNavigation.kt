package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.composables.ManageSubscriptions

fun NavController.navigateToManageSubscriptions(subId: Long) {
    val navDestination = NavDestination.ManageSubscriptions.destination
        .replace("{subId}", subId.toString())
    this.navigate(navDestination)
}

fun Navigator.navigateToManageSubscriptions(subId: Long) {
    val navDestination = NavDestination.ManageSubscriptions.destination
        .replace("{subId}", subId.toString())
    this.navigateTo(navDestination)
}

fun NavGraphBuilder.manageSubscriptionsScreen(
    popBackStack: () -> Unit
) {
    composable(
        route = NavDestination.ManageSubscriptions.destination,
        arguments = listOf(
            navArgument("subId") { type = NavType.LongType }
        )
    ) {
        ManageSubscriptions(
            subEntityId = it.arguments?.getLong("subId") ?: 0,
            popBackStack = popBackStack,
        )
    }
}