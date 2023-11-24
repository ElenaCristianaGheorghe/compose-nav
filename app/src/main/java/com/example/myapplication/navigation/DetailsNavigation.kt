package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.composables.Details

fun NavController.navigateToDetails(subId: Long) {
    val navDestination = NavDestination.SubDetails.destination.replace("{subId}", subId.toString())
    this.navigate(navDestination)
}

fun Navigator.navigateToDetails(subId: Long) {
    val navDestination = NavDestination.SubDetails.destination.replace("{subId}", subId.toString())
    this.navigateTo(navDestination)
}
fun NavGraphBuilder.detailsScreen(
    popBackStack: () -> Unit
) {
    composable(
        route = NavDestination.SubDetails.destination,
        arguments = listOf(
            navArgument("subId") { type = NavType.LongType }
        )
    ) {
        Details(
            subEntityId = it.arguments?.getLong("subId") ?: 0,
            popBackStack = popBackStack
        )
    }
}