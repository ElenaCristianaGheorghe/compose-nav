package com.example.myapplication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.example.myapplication.composables.AddNewSub
import com.example.myapplication.composables.Details
import com.example.myapplication.composables.Home
import com.example.myapplication.composables.ManageSubscriptions
import com.example.myapplication.composables.SubscriptionOptions
import com.example.myapplication.composables.TestFragmentScreen
import com.example.myapplication.databinding.TestFragmentContainerBinding
import com.example.myapplication.fragments.NavDestinationFragment
import com.example.navigation.GraphRoot
import com.example.navigation.NavDestinationRoutes
import com.example.navigation.destinations.addNewSubScreen
import com.example.navigation.destinations.detailsScreen
import com.example.navigation.destinations.homeScreen
import com.example.navigation.destinations.manageSubscriptionsScreen
import com.example.navigation.destinations.subscriptionOptionsScreen
import com.example.navigation.destinations.testFragmentScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavController
) {
    navigation(
        route = GraphRoot.MAIN,
        startDestination = NavDestinationRoutes.Home.destination
    ) {
        homeScreen { Home() }

        addNewSubScreen { AddNewSub(popBackStack = navController::popBackStack) }

        detailsScreen { subId ->
            Details(
                subEntityId = subId,
                popBackStack = navController::popBackStack
            )
        }

        subscriptionOptionsScreen { subId, expirationDate ->
            SubscriptionOptions(
                subEntityId = subId,
                expirationDate = expirationDate,
                popBackStack = navController::popBackStack
            )
        }

        manageSubscriptionsScreen { subId ->
            ManageSubscriptions(
                subEntityId = subId,
                popBackStack = navController::popBackStack,
            )
        }

        testFragmentScreen {
            TestFragmentScreen(
                androidViewBindingFactory = TestFragmentContainerBinding::inflate,
                androidViewBindingUpdate = {
                    testFragmentContainerView.getFragment<NavDestinationFragment>()
                },
                popBackStack = navController::popBackStack,
            )
        }
    }
}