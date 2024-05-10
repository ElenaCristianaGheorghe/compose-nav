package com.example.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
data class SubscriptionOptionsDestination(
    val subId: Long,
    val expirationDate: Long
): Destination

fun NavGraphBuilder.subscriptionOptionsScreen(
   content: @Composable (Long, Long) -> Unit
) {
    composable<SubscriptionOptionsDestination> {
        val (subId, expirationDate) = it.toRoute<SubscriptionOptionsDestination>()
        content(subId, expirationDate)
    }
}