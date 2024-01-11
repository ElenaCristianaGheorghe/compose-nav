package com.example.navigation

sealed class NavDestinationRoutes(val destination: String) {
    data object Home: NavDestinationRoutes("home")
    data object SubDetails: NavDestinationRoutes("subDetails/{subId}")
    data object AddNewSub: NavDestinationRoutes("addNewSub")
    data object SubscriptionOptions: NavDestinationRoutes("subOptions/{subId}?expirationDate={expirationDate}")
    data object ManageSubscriptions: NavDestinationRoutes("manageSubs/{subId}")
    data object TestFragment: NavDestinationRoutes("testFragment")
    data object Authentication: NavDestinationRoutes("authentication")
    data object Registration: NavDestinationRoutes("registration")

}