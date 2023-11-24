package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.myapplication.composables.AddNewSub

fun NavController.navigateToAddNewSub() {
    this.navigate(NavDestination.AddNewSub.destination)
}

fun Navigator.navigateToAddNewSub() {
    this.navigateTo(NavDestination.AddNewSub.destination)
}

fun NavGraphBuilder.addNewSubScreen(
    popBackStack: () -> Unit
) {
    composable(route = NavDestination.AddNewSub.destination) {
        AddNewSub(popBackStack = popBackStack)
    }
}