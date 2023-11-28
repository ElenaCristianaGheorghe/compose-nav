package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.navigation.NavDestinationRoutes
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {
    fun navigateToSubscriptionOptions(subId: Long, expirationDate: Long?) {
        val navDestinationRoutes = NavDestinationRoutes.SubscriptionOptions.destination
            .replace("{subId}", subId.toString())
            .replace("{expirationDate}", expirationDate.toString())
        navigator.navigateTo(navDestinationRoutes)
    }

    fun navigateToManageSubscriptions(subId: Long) {
        val navDestinationRoutes = NavDestinationRoutes.ManageSubscriptions.destination
            .replace("{subId}", subId.toString())
        navigator.navigateTo(navDestinationRoutes)
    }
}