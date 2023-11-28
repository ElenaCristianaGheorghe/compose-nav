package com.example.myapplication.composables.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    showNavigationIcon: Boolean = true,
    popBackStack: () -> Unit = {}
) {
    val context = LocalContext.current

    TopAppBar(
        title = {
            Text(
                title,
                color = Color.White
            )
        },
        navigationIcon = {
            if (showNavigationIcon) {
                IconButton(
                    onClick = popBackStack
                ) {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xFF018786))
    )
}