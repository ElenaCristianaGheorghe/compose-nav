package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.myapplication.composables.AddNewUser

fun NavController.navigateToAddNewUser() {
    this.navigate(NavDestination.AddNewUser.destination)
}

fun Navigator.navigateToAddNewUser() {
    this.navigateTo(NavDestination.AddNewUser.destination)
}

fun NavGraphBuilder.addNewUserScreen(
    popBackStack: () -> Unit
) {
    composable(route = NavDestination.AddNewUser.destination) {
        AddNewUser(popBackStack = popBackStack)
    }
}