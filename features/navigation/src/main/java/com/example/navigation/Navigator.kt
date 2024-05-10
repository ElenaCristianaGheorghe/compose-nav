package com.example.navigation

import com.example.navigation.destinations.Destination
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Singleton

@Singleton
class Navigator {
    private val _sharedFlow = MutableSharedFlow<Pair<Destination, Boolean>>(extraBufferCapacity = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(navDestination: Destination, inclusive: Boolean = false) {
        _sharedFlow.tryEmit(Pair(navDestination, inclusive))
    }
}