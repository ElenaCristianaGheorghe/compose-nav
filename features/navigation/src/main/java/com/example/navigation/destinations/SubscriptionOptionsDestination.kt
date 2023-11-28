package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navigation.NavDestinationRoutes

fun NavGraphBuilder.subscriptionOptionsScreen(
   content: @Composable (Long, Long) -> Unit
) {
    composable(
        route = NavDestinationRoutes.SubscriptionOptions.destination,
        arguments = listOf(
            navArgument("subId") { type = NavType.LongType },
            navArgument("expirationDate") {
                type = NavType.LongType
                defaultValue = 0
            }
        )
    ) {
        content(
            it.arguments?.getLong("subId") ?: 0,
            it.arguments?.getLong("expirationDate") ?: 0
        )
    }
}