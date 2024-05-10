package com.example.myapplication.composables

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.composables.common.TopBar
import com.example.myapplication.utils.collectAsStateLifecycleAware
import com.example.myapplication.viewModels.SubViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewSub(
    subViewModel: SubViewModel = viewModel(LocalContext.current as ComponentActivity),
    popBackStack: () -> Unit,
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var subName by rememberSaveable { mutableStateOf("") }
    var subValidity by rememberSaveable { mutableLongStateOf(0L) }

    val subNumber by subViewModel.subsNumberStateFlow.collectAsStateLifecycleAware()

    Scaffold(
        topBar = {
            TopBar(
                title = "Add new subscription",
                popBackStack = popBackStack
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentPadding = it,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    text = "Total subscriptions: $subNumber",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp
                )
            }
            item {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    value = subName,
                    onValueChange = { input -> subName = input },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    label = {
                        Text(
                            text = "Subscription name",
                            textAlign = TextAlign.Start,
                            fontSize = 14.sp
                        )
                    }
                )
            }
            item {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    value = if (subValidity > 0) subValidity.toString() else  "",
                    onValueChange = { input -> subValidity = input.toLong() },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { keyboardController?.hide() }
                    ),
                    label = {
                        Text(
                            text = "Subscription validity (months)",
                            textAlign = TextAlign.Start,
                            fontSize = 14.sp
                        )
                    }
                )
            }
            item {
                Button(
                    modifier = Modifier.padding(12.dp),
                    onClick = {
                        if (subName.isNotEmpty()) {
                            subViewModel.insertSub(subName, subValidity)
                            keyboardController?.hide()
                            Toast.makeText(context, "Subscription $subName", Toast.LENGTH_SHORT)
                                .show()
                            subName = ""
                            subValidity = 0
                        } else {
                            Toast.makeText(context, "Invalid info", Toast.LENGTH_SHORT).show()
                        }
                    }
                ) {
                    Text(text = "Add new subscription")
                }
            }
        }
    }
}