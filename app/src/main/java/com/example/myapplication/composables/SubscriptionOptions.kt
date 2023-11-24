package com.example.myapplication.composables

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.composables.common.TopBar
import com.example.myapplication.viewModels.SubViewModel
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionOptions(
    subViewModel: SubViewModel = viewModel(LocalContext.current as ComponentActivity),
    subEntityId: Long,
    expirationDate: Long,
    popBackStack: () -> Unit
) {
    val text = if (expirationDate < System.currentTimeMillis()){
        "Subscription expired"
    } else {
        val subscription = subViewModel.getSubById(subEntityId)
        "Your ${subscription.name} subscription is valid until ${Date(expirationDate)}"
    }

    Scaffold(
        topBar = {
            TopBar(
                title = "Latest subscription details",
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
                    text = text,
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp
                )
            }
        }
    }
}