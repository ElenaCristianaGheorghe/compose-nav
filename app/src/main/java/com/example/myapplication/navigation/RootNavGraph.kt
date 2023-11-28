package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.authentication.navigation.authNavGraph
import com.example.navigation.GraphRoot
import com.example.navigation.NavDestinationRoutes

@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = GraphRoot.ROOT,
        startDestination = GraphRoot.AUTH
    ) {
        authNavGraph(navController)
        mainNavGraph(navController)
    }
}