package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object AddNewSubDestination: Destination

fun NavGraphBuilder.addNewSubScreen(
    content: @Composable ()  -> Unit
) {
    composable<AddNewSubDestination> {
        content()
    }
}