package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
object TestFragmentDestination: Destination

fun NavGraphBuilder.testFragmentScreen(
    content: @Composable () -> Unit
) {
    composable<TestFragmentDestination> {
        content()
    }
}