package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.navigation.MyNavHost
import com.example.myapplication.navigation.Navigator
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigator: Navigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                LaunchedEffect("navigation") {
                    navigator.sharedFlow.onEach {
                        navController.navigate(it) {
                           popUpTo(it) // wichtig, damit der backstack aus unique nav entries besteht (auf Parameter achten)
                        }
                    }.launchIn(this)
                }
                
                MyNavHost(navController)
            }
        }
    }
}