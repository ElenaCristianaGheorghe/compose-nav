package com.example.navigation.utils

import androidx.navigation.NavHostController
import com.example.navigation.Navigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

object NavigationUtils {
    fun startNavigation(
        coroutineScope: CoroutineScope,
        navigator: Navigator,
        navController: NavHostController
    ) {
        navigator.sharedFlow.onEach {
            val destinationRoute = it.first
            val removeFromBackStack = it.second
            navController.navigate(destinationRoute) {
                val currentBackStackEntryRoute = navController.currentBackStackEntry?.destination?.route
                if (removeFromBackStack && currentBackStackEntryRoute != null) {
                    popUpTo(navController.currentBackStackEntry?.destination?.route!!) {
                        inclusive = true
                    }
                }
            }
        }.launchIn(coroutineScope)
    }
}