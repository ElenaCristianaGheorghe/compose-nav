package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.navigation.Navigator
import com.example.navigation.destinations.ManageSubscriptionDestination
import com.example.navigation.destinations.SubscriptionOptionsDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {
    fun navigateToSubscriptionOptions(subId: Long, expirationDate: Long?) {
        navigator.navigateTo(SubscriptionOptionsDestination(subId, expirationDate?: 0))
    }

    fun navigateToManageSubscriptions(subId: Long) {
        navigator.navigateTo(ManageSubscriptionDestination(subId))
    }
}