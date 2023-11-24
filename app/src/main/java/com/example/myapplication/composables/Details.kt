package com.example.myapplication.composables

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
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
import com.example.myapplication.viewModels.DetailsViewModel
import com.example.myapplication.viewModels.SubViewModel
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(
    subViewModel: SubViewModel = viewModel(LocalContext.current as ComponentActivity),
    detailsViewModel: DetailsViewModel = viewModel(LocalContext.current as ComponentActivity),
    subEntityId: Long,
    popBackStack: () -> Unit
) {
    val subEntity = subViewModel.getSubById(subEntityId)

    Scaffold(
        topBar = {
            TopBar(
                title = "Details",
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
                    text = "Subscription: \n" + "" +
                        "${subEntity.name} (id: ${subEntity.id}) - creation time: ${Date(subEntity.creationTime)}",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp
                )
            }
            item {
                Button(
                    modifier = Modifier.padding(vertical = 12.dp),
                    onClick = {
                        detailsViewModel.navigateToSubscriptionOptions(
                            subEntity.id,
                            subViewModel.getLatestDetailsBySubId(subEntity.id)
                        )
                    }
                ) {
                  Text(text = "Check latest subscription")
                }
            }
            item {
                Button(
                    onClick = { detailsViewModel.navigateToManageSubscriptions(subEntityId) }
                ) {
                    Text(text = "Manage subscriptions")
                }
            }
        }
    }
}