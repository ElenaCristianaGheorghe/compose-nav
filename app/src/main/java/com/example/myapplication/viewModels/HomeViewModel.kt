package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.navigation.NavDestinationRoutes
import com.example.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {
     fun navigateToDetails(subId: Long) {
         val navDestinationRoutes = NavDestinationRoutes.SubDetails.destination
             .replace("{subId}", subId.toString())
         navigator.navigateTo(navDestinationRoutes)
     }
    fun navigateToAddNewUser() = navigator.navigateTo(NavDestinationRoutes.AddNewSub.destination)
    fun navigateToTestFragment() = navigator.navigateTo(NavDestinationRoutes.TestFragment.destination)
}