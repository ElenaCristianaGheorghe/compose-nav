package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object RegistrationDestination: Destination

fun NavGraphBuilder.registrationScreen(
    content: @Composable () -> Unit
) {
    composable<RegistrationDestination> {
        content()
    }
}