package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navigation.NavDestinationRoutes

fun NavGraphBuilder.detailsScreen(
    content: @Composable (Long) -> Unit
) {
    composable(
        route = NavDestinationRoutes.SubDetails.destination,
        arguments = listOf(
            navArgument("subId") { type = NavType.LongType }
        )
    ) {
        content(it.arguments?.getLong("subId") ?: 0)
    }
}