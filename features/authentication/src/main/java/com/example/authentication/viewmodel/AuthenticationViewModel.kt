package com.example.authentication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.navigation.Navigator
import com.example.navigation.destinations.HomeDestination
import com.example.navigation.destinations.RegistrationDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val navigator: Navigator
): ViewModel() {

    private var authInfoList = CONST_AUTH_INFO
    fun startAuthentication(
        email: String,
        password: String
    ): Boolean {
        authInfoList.forEach { authInfo ->
            if (authInfo.first == email && authInfo.second == password) {
                navigator.navigateTo(HomeDestination, true)
                return true
            }
        }
        return false
    }

    fun startRegistration(email: String, password: String): Boolean {
        if (email.isNotEmpty() && password.isNotEmpty())
            return authInfoList.add(Pair(email, password))
        return false
    }

    fun navigateToRegistration() = navigator.navigateTo(RegistrationDestination)

    companion object {
        val CONST_AUTH_INFO = mutableListOf(
            Pair("example@example.com", "example"),
            Pair("elena@example.com", "elena")
        )
    }
}