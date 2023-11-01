package com.example.myapplication.navigation

sealed class NavDestination(val destination: String) {
    object Home: NavDestination("home")
    object UserDetails: NavDestination("userDetails/{userId}")
    object AddNewUser: NavDestination("addNewUser")
    object SubscriptionOptions: NavDestination("subOptions/{userId}?expirationDate={expirationDate}")
    object ManageSubscriptions: NavDestination("manageSubs/{userId}")
}