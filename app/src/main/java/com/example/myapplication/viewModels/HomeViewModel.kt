package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.myapplication.navigation.Navigator
import com.example.myapplication.navigation.navigateToAddNewSub
import com.example.myapplication.navigation.navigateToDetails
import com.example.myapplication.navigation.navigateToTestFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {
     fun navigateToDetails(subId: Long) = navigator.navigateToDetails(subId)
    fun navigateToAddNewUser() = navigator.navigateToAddNewSub()
    fun navigateToTestFragment() = navigator.navigateToTestFragment()
}