package com.example.myapplication.composables

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.composables.common.TopBar
import com.example.myapplication.viewModels.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    userViewModel: UserViewModel = viewModel(LocalContext.current as ComponentActivity),
    navigateToDetails: (Long) -> Unit,
    navigateToAddNewUser: () -> Unit
) {
    Scaffold(
        topBar = { TopBar(title = "Home", showNavigationIcon = false) }
    ) {
        LazyColumn(contentPadding = it) {
            item {
                Button(
                    onClick = navigateToAddNewUser
                ) {
                    Text(text = "Insert new user")
                }
            }
            items(userViewModel.getUsers()) { user ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navigateToDetails(user.id) },
                    text = user.name
                )
            }
        }
    }
}