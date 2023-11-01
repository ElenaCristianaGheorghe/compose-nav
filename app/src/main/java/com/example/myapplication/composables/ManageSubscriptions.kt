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
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.composables.common.TopBar
import com.example.myapplication.utils.collectAsStateLifecycleAware
import com.example.myapplication.viewModels.UserViewModel

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ManageSubscriptions(
    userViewModel: UserViewModel = viewModel(LocalContext.current as ComponentActivity),
    userId: Long,
    popBackStack: () -> Unit,
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var subValidity by rememberSaveable { mutableLongStateOf(0L) }

    val allSubs by userViewModel.loadSubscriptionByUserId(userId).collectAsStateLifecycleAware()
    val latestExpirationDate by userViewModel.loadLatestSubByUserId(userId).collectAsStateLifecycleAware()

    Scaffold(
        topBar = {
            TopBar(
                title = "Manage subscriptions",
                popBackStack = popBackStack
            )
        }
    ) {
        LazyColumn(contentPadding = it) {
            item {
                Text(text = "All subscriptions: $allSubs")
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
                    label = { Text("Add new subscription (only if you don't have an active one)") }
                )
            }
            item {
                Button(
                    onClick = {
                        if ((latestExpirationDate == null || latestExpirationDate!! < System.currentTimeMillis()) && subValidity > 0) {
                            userViewModel.insertSubscription(userId, subValidity)
                            Toast.makeText(context, "New subscription added", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "Couldn't add a new subscription", Toast.LENGTH_SHORT).show()
                        }
                    }
                ) {
                    Text(text = "Add new subscription")
                }
            }
        }
    }
}