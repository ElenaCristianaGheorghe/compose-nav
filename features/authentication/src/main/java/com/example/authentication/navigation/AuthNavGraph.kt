package com.example.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.authentication.composables.AuthenticationScreen
import com.example.authentication.composables.RegistrationScreen
import com.example.navigation.GraphRoot
import com.example.navigation.NavDestinationRoutes
import com.example.navigation.destinations.authScreen
import com.example.navigation.destinations.registrationScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {
    navigation(
        route = GraphRoot.AUTH,
        startDestination = NavDestinationRoutes.Authentication.destination
    ) {
        authScreen { AuthenticationScreen() }
        registrationScreen { RegistrationScreen { navController.popBackStack() } }
    }
}