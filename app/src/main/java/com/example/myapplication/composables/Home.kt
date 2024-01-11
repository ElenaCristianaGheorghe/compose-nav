package com.example.myapplication.composables

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.secondactivity.SecondActivity
import com.example.myapplication.composables.common.TopBar
import com.example.myapplication.viewModels.HomeViewModel
import com.example.myapplication.viewModels.SubViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    subsViewModel: SubViewModel = viewModel(LocalContext.current as ComponentActivity),
    homeViewModel: HomeViewModel = viewModel(LocalContext.current as ComponentActivity)
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopBar(title = "Subscriptions management",
                showNavigationIcon = false)
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
                    modifier = Modifier.fillMaxWidth(),
                    text = "Keep track of your subscriptions from one place!",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
            }
            item {
                Button(
                    modifier = Modifier.padding(12.dp),
                    onClick = homeViewModel::navigateToAddNewUser
                ) {
                    Text(text = "Insert new subscription")
                }
            }
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    text = "On going subscriptions: ",
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp
                )
            }
            items(
                subsViewModel.getSubs()
            ) { sub ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { homeViewModel.navigateToDetails(sub.id) }
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        text = sub.name,
                        textAlign = TextAlign.Start,
                        fontSize = 14.sp
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.Gray)
                    )
                }
            }
            item {
                Button(
                    modifier = Modifier.padding(12.dp),
                    onClick = homeViewModel::navigateToTestFragment
                ) {
                    Text(text = "Navigate to Test Fragment Screen")
                }
            }
            item {
                Button(
                    modifier = Modifier.padding(12.dp),
                    onClick = { context.startActivity(Intent(context, SecondActivity::class.java)) }
                ) {
                    Text(text = "Navigate to another activity")
                }
            }
        }
    }
}