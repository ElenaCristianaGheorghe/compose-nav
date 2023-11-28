package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.NavDestinationRoutes

fun NavGraphBuilder.registrationScreen(
    content: @Composable () -> Unit
) {
    composable(route = NavDestinationRoutes.Registration.destination) {
        content()
    }
}