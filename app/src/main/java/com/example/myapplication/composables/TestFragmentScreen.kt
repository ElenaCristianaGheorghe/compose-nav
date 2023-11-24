package com.example.myapplication.composables

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.viewbinding.ViewBinding
import com.example.myapplication.composables.common.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : ViewBinding> TestFragmentScreen(
    androidViewBindingFactory: (inflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean) -> T,
    popBackStack: () -> Unit,
    androidViewBindingUpdate: T.() -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopBar(
                title = "Test Fragment Screen",
                popBackStack = popBackStack
            )
        }
    ) {
        AndroidViewBinding(
            factory = androidViewBindingFactory,
            modifier = Modifier.padding(it),
            update = androidViewBindingUpdate,
        )
    }
}