package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.myapplication.navigation.Navigator
import com.example.myapplication.navigation.navigateToManageSubscriptions
import com.example.myapplication.navigation.navigateToSubscriptionOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {
    fun navigateToSubscriptionOptions(subId: Long, expirationDate: Long?) =
        navigator.navigateToSubscriptionOptions(subId, expirationDate)

    fun navigateToManageSubscriptions(subId: Long) = navigator.navigateToManageSubscriptions(subId)
}