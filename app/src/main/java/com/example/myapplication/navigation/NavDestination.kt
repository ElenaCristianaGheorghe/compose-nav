package com.example.myapplication.navigation

sealed class NavDestination(val destination: String) {
    object Home: NavDestination("home")
    object SubDetails: NavDestination("subDetails/{subId}")
    object AddNewSub: NavDestination("addNewSub")
    object SubscriptionOptions: NavDestination("subOptions/{subId}?expirationDate={expirationDate}")
    object ManageSubscriptions: NavDestination("manageSubs/{subId}")
    object TestFragment: NavDestination("testFragment")
}