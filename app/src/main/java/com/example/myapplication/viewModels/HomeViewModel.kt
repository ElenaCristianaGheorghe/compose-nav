package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import com.example.myapplication.navigation.Navigator
import com.example.myapplication.navigation.navigateToAddNewUser
import com.example.myapplication.navigation.navigateToDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {
     fun navigateToDetails(userId: Long) = navigator.navigateToDetails(userId)
    fun navigateToAddNewUser() = navigator.navigateToAddNewUser()
}