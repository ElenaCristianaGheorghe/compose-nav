package com.example.myapplication.composables

import androidx.activity.ComponentActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.composables.common.TopBar
import com.example.myapplication.viewModels.UserViewModel
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionOptions(
    userViewModel: UserViewModel = viewModel(LocalContext.current as ComponentActivity),
    userId: Long,
    expirationDate: Long,
    popBackStack: () -> Unit
) {
    val text = if (expirationDate < System.currentTimeMillis()){
        "Subscription expired"
    } else {
        val user = userViewModel.getUserById(userId)
        "${user.name} your subscription is valid until ${Date(expirationDate)}"
    }

    Scaffold(
        topBar = {
            TopBar(
                title = "Latest subscription details",
                popBackStack = popBackStack
            )
        }
    ) {
        LazyColumn(contentPadding = it) {
            item {
                Text(text = text)
            }
        }
    }
}