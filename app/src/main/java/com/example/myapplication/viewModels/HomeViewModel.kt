package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.navigation.Navigator
import com.example.navigation.destinations.AddNewSubDestination
import com.example.navigation.destinations.DetailsDestination
import com.example.navigation.destinations.TestFragmentDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {
     fun navigateToDetails(subId: Long) = navigator.navigateTo(DetailsDestination(subId))
    fun navigateToAddNewUser() = navigator.navigateTo(AddNewSubDestination)
    fun navigateToTestFragment() = navigator.navigateTo(TestFragmentDestination)
}