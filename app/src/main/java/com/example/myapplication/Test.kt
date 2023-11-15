package com.example.myapplication

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
fun <T : ViewBinding> FragmentHolderScreen(
    topBarTitle: String,
    androidViewBindingFactory: (inflater: LayoutInflater, parent: ViewGroup, attachToParent: Boolean) -> T,
    onBackPress: () -> Unit = {},
    androidViewBindingUpdate: T.() -> Unit = {},
) {
//    Scaffold(
//        topBar = {
//            TopBar(title = topBarTitle)
//        },
//        content = { paddingValues ->
            AndroidViewBinding(
                factory = androidViewBindingFactory,
                //modifier = Modifier.padding(paddingValues),
                update = androidViewBindingUpdate,
            )
//        },
                //)
}