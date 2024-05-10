package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object AuthenticationDestination: Destination

fun NavGraphBuilder.authScreen(
    content: @Composable () -> Unit
) {
    composable<AuthenticationDestination> {
        content()
    }
}