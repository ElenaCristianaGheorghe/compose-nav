package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.authentication.navigation.authNavGraph
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.navigation.GraphRoute
import com.example.navigation.Navigator
import com.example.navigation.utils.NavigationUtils

@Composable
fun RootNavGraph(
    navigator: Navigator
) {
    val navController = rememberNavController()

    MyApplicationTheme {
        NavHost(
            navController = navController,
            route = GraphRoute.Root::class,
            startDestination = GraphRoute.Main
        ) {
            authNavGraph(navController)
            mainNavGraph(navController)
        }
    }
    LaunchedEffect(NAVIGATION) {
        NavigationUtils.startNavigation(this, navigator, navController)
    }
}

const val NAVIGATION = "navigation"