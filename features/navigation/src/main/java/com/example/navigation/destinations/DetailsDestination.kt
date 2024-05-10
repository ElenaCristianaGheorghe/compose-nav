package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class DetailsDestination(val subId: Long): Destination

fun NavGraphBuilder.detailsScreen(
    content: @Composable (Long) -> Unit
) {
    composable<DetailsDestination> {
        val details: DetailsDestination = it.toRoute()
        content(details.subId)
    }
}