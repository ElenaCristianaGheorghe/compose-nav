package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.navigation.NavDestinationRoutes

fun NavGraphBuilder.testFragmentScreen(
    content: @Composable () -> Unit
) {
    composable(route = NavDestinationRoutes.TestFragment.destination) {
        content()
    }
}