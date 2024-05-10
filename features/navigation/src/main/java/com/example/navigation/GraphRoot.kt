package com.example.navigation

import kotlinx.serialization.Serializable
@Serializable
sealed class GraphRoute(val name: String) {
    @Serializable
    data object Auth: GraphRoute(AUTH)
    @Serializable
    data object Main: GraphRoute(MAIN)

    @Serializable
    data object Root: GraphRoute(ROOT)

    companion object {
        private const val AUTH = "AUTH"
        private const val MAIN = "MAIN"
        private const val ROOT = "ROOT"
    }
}