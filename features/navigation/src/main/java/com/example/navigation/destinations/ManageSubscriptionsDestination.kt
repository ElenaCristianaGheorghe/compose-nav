package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class ManageSubscriptionDestination(val subId: Long): Destination

fun NavGraphBuilder.manageSubscriptionsScreen(
    content: @Composable (Long) -> Unit
) {
    composable<ManageSubscriptionDestination> {
        val subId = it.toRoute<ManageSubscriptionDestination>().subId
        content(subId)
    }
}