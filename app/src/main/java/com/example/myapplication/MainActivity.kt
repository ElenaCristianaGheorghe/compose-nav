package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavDestination
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.RootNavGraph
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.navigation.NavDestinationRoutes
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
                        val inclusive1 = it.second
                        navController.navigate(destinationRoute) {
                            Log.i("ELENA","${navController.currentBackStackEntry?.destination?.route}")
                            if (inclusive1 && navController.currentBackStackEntry?.destination?.route != null) {
                                popUpTo(navController.currentBackStackEntry?.destination?.route!!)
                                    { inclusive = inclusive1 }
                            } else popUpTo(destinationRoute) // wichtig, damit der backstack aus unique nav entries besteht (auf Parameter achten)
                        }
                    }.launchIn(this)
                }

                RootNavGraph(navController)
            }
        }
    }
}