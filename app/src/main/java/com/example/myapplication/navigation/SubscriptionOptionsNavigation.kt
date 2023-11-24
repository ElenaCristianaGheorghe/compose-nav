package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.composables.SubscriptionOptions

fun NavController.navigateToSubscriptionOptions(subId: Long, expirationDate: Long?) {
    val navDestination = NavDestination.SubscriptionOptions.destination
        .replace("{subId}", subId.toString())
        .replace("{expirationDate}", expirationDate.toString())
    this.navigate(navDestination)
}

fun Navigator.navigateToSubscriptionOptions(subId: Long, expirationDate: Long?) {
    val navDestination = NavDestination.SubscriptionOptions.destination
        .replace("{subId}", subId.toString())
        .replace("{expirationDate}", expirationDate.toString())
    this.navigateTo(navDestination)
}

fun NavGraphBuilder.subscriptionOptionsScreen(
    popBackStack: () -> Unit,
) {
    composable(
        route = NavDestination.SubscriptionOptions.destination,
        arguments = listOf(
            navArgument("subId") { type = NavType.LongType },
            navArgument("expirationDate") {
                type = NavType.LongType
                defaultValue = 0
            }
        )
    ) {
        SubscriptionOptions(
            subEntityId = it.arguments?.getLong("subId") ?: 0,
            expirationDate = it.arguments?.getLong("expirationDate") ?: 0,
            popBackStack = popBackStack
        )
    }
}