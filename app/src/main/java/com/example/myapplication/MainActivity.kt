package com.example.myapplication

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.RootNavGraph
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.navigation.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigator: Navigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                LaunchedEffect("navigation") {
                    navigator.sharedFlow.onEach {
                        val destinationRoute = it.first
                        val removeFromBackStack = it.second
                        navController.navigate(destinationRoute) {
                            val currentBackStackEntryRoute = navController.currentBackStackEntry?.destination?.route
                            if (removeFromBackStack && currentBackStackEntryRoute != null) {
                                popUpTo(navController.currentBackStackEntry?.destination?.route!!)
                                    { inclusive = true }
                            } else popUpTo(destinationRoute)
                        }
                    }.launchIn(this)
                }

                RootNavGraph(navController)
            }
        }
    }
}