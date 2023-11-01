package com.example.myapplication.composables

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.composables.common.TopBar
import com.example.myapplication.utils.collectAsStateLifecycleAware
import com.example.myapplication.viewModels.UserViewModel


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun AddNewUser(
    userViewModel: UserViewModel = viewModel(LocalContext.current as ComponentActivity),
    popBackStack: () -> Unit,
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var userName by rememberSaveable { mutableStateOf("") }
    var subValidity by rememberSaveable { mutableStateOf(0L) }

    val usersNumber by userViewModel.usersNumberStateFlow.collectAsStateLifecycleAware()

    Scaffold(
        topBar = {
            TopBar(
                title = "Add new user",
                popBackStack = popBackStack
            )
        }
    ) {
        LazyColumn(contentPadding = it) {
            item {
                Text(text = "Total users: $usersNumber")
            }
            item {
                TextField(
                    value = userName,
                    onValueChange = { input -> userName = input },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    label = { Text("User name") }
                )
            }
            item {
                TextField(
                    value = if (subValidity > 0) subValidity.toString() else  "",
                    onValueChange = { input -> subValidity = input.toLong() },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    label = { Text("Subscription validity (month)") }
                )
            }
            item {
                Button(
                    onClick = {
                        if (userName.isNotEmpty()) {
                            userViewModel.insertUser(userName, subValidity)
                            keyboardController?.hide()
                            Toast.makeText(context, "User $userName", Toast.LENGTH_SHORT).show()
                            userName = ""
                            subValidity = 0
                        } else {
                            Toast.makeText(context, "Invalid info", Toast.LENGTH_SHORT).show()
                        }
                    }
                ) {
                    Text(text = "Add new user")
                }
            }
        }
    }
}