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
import com.example.myapplication.viewModels.DetailsViewModel
import com.example.myapplication.viewModels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(
    userViewModel: UserViewModel = viewModel(LocalContext.current as ComponentActivity),
    detailsViewModel: DetailsViewModel = viewModel(LocalContext.current as ComponentActivity),
    userId: Long,
    popBackStack: () -> Unit
) {
    val user = userViewModel.getUserById(userId)
    Scaffold(
        topBar = {
            TopBar(
                title = "Details",
                popBackStack = popBackStack
            )
        }
    ) {
        LazyColumn(contentPadding = it) {
            item {
                Text(text = "Hello: ${user.name} (id: ${user.id}) creation time ${user.creationTime}")
            }
            item {
                Button(
                    onClick = {
                        detailsViewModel.navigateToSubscriptionOptions(
                            user.id,
                            userViewModel.getLatestSubByUserId(userId)
                        )
                    }
                ) {
                  Text(text = "Check latest subscription")
                }
            }
            item {
                Button(
                    onClick = { detailsViewModel.navigateToManageSubscriptions(userId) }
                ) {
                    Text(text = "Manage subscriptions")
                }
            }
        }
    }
}