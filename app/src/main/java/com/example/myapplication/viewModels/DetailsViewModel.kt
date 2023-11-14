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
    fun navigateToSubscriptionOptions(userId: Long, expirationDate: Long?) =
        navigator.navigateToSubscriptionOptions(userId, expirationDate)

    fun navigateToManageSubscriptions(userId: Long) = navigator.navigateToManageSubscriptions(userId)
}