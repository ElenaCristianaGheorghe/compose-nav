package com.example.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.authentication.composables.AuthenticationScreen
import com.example.authentication.composables.RegistrationScreen
import com.example.navigation.GraphRoute
import com.example.navigation.destinations.AuthenticationDestination
import com.example.navigation.destinations.authScreen
import com.example.navigation.destinations.registrationScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {
    navigation<GraphRoute.Auth>(
        startDestination = AuthenticationDestination
    ) {
        authScreen { AuthenticationScreen() }
        registrationScreen { RegistrationScreen { navController.popBackStack() } }
    }
}