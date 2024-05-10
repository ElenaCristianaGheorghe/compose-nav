package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object HomeDestination: Destination

fun NavGraphBuilder.homeScreen(
    content: @Composable () -> Unit
) {
    composable<HomeDestination> {
        content()
    }
}

