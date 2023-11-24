package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.myapplication.composables.TestFragmentScreen
import com.example.myapplication.databinding.TestFragmentContainerBinding
import com.example.myapplication.fragments.TestFragment

fun NavController.navigateToTestFragment() {
    this.navigate(NavDestination.TestFragment.destination)
}

fun Navigator.navigateToTestFragment() {
    this.navigateTo(NavDestination.TestFragment.destination)
}

fun NavGraphBuilder.testFragmentScreen(
    popBackStack: () -> Unit
) {
    composable(route = NavDestination.TestFragment.destination) {
        TestFragmentScreen(
            androidViewBindingFactory = TestFragmentContainerBinding::inflate,
            androidViewBindingUpdate = {
                testFragmentContainerView.getFragment<TestFragment>()
            },
            popBackStack = popBackStack,
        )
    }
}