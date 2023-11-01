package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.composables.SubscriptionOptions

fun NavController.navigateToSubscriptionOptions(userId: Long, expirationDate: Long?) {
    val navDestination = NavDestination.SubscriptionOptions.destination
        .replace("{userId}", userId.toString())
        .replace("{expirationDate}", expirationDate.toString())
    this.navigate(navDestination)
}

fun NavGraphBuilder.subscriptionOptionsScreen(
    popBackStack: () -> Unit,
) {
    composable(
        route = NavDestination.SubscriptionOptions.destination,
        arguments = listOf(
            navArgument("userId") { type = NavType.LongType },
            navArgument("expirationDate") {
                type = NavType.LongType
                defaultValue = 0
            }
        )
    ) {
        SubscriptionOptions(
            userId = it.arguments?.getLong("userId") ?: 0,
            expirationDate = it.arguments?.getLong("expirationDate") ?: 0,
            popBackStack = popBackStack
        )
    }
}