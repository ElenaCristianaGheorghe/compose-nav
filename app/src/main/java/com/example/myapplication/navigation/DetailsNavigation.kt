package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.composables.Details

fun NavController.navigateToDetails(userId: Long) {
    val navDestination = NavDestination.UserDetails.destination.replace("{userId}", userId.toString())
    this.navigate(navDestination)
}

fun Navigator.navigateToDetails(userId: Long) {
    val navDestination = NavDestination.UserDetails.destination.replace("{userId}", userId.toString())
    this.navigateTo(navDestination)
}
fun NavGraphBuilder.detailsScreen(
    popBackStack: () -> Unit
) {
    composable(
        route = NavDestination.UserDetails.destination,
        arguments = listOf(
            navArgument("userId") { type = NavType.LongType }
        )
    ) {
        Details(
            userId = it.arguments?.getLong("userId") ?: 0,
            popBackStack = popBackStack
        )
    }
}