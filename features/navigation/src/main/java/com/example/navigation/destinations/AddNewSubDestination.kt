package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.NavDestinationRoutes

fun NavGraphBuilder.addNewSubScreen(
    content: @Composable ()  -> Unit
) {
    composable(route = NavDestinationRoutes.AddNewSub.destination) {
        content()
    }
}