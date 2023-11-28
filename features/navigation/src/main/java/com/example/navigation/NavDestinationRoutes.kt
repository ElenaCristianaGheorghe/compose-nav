package com.example.navigation

sealed class NavDestinationRoutes(val destination: String) {
    object Home: NavDestinationRoutes("home")
    object SubDetails: NavDestinationRoutes("subDetails/{subId}")
    object AddNewSub: NavDestinationRoutes("addNewSub")
    object SubscriptionOptions: NavDestinationRoutes("subOptions/{subId}?expirationDate={expirationDate}")
    object ManageSubscriptions: NavDestinationRoutes("manageSubs/{subId}")
    object TestFragment: NavDestinationRoutes("testFragment")
    object Authentication: NavDestinationRoutes("authentication")
    object Registration: NavDestinationRoutes("registration")

}