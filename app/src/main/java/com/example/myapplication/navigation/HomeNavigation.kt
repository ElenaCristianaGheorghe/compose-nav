package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.myapplication.FragmentHolderScreen
import com.example.myapplication.composables.Home
import com.example.myapplication.databinding.FrTestBinding
import com.example.myapplication.databinding.FrTestContainerBinding
import com.example.myapplication.fragments.TestFragment

fun NavController.navigateToHome() {
    this.navigate(NavDestination.Home.destination)
}

fun Navigator.navigateToHome() {
    this.navigateTo(NavDestination.Home.destination)
}

fun NavGraphBuilder.homeScreen(
) {
    composable(route = NavDestination.Home.destination) {
        homeScreen()
//        FragmentHolderScreen(
//            topBarTitle = "Hello",
//            androidViewBindingFactory = FrTestContainerBinding::inflate,
//            androidViewBindingUpdate = {
//                fragmentContainerViewEvents.getFragment<TestFragment>()
//        },
//        onBackPress = {},
//        )
    }
}

