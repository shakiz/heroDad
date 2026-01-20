package com.journey.heroDad.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.journey.heroDad.navigation.graph.authNavGraph
import com.journey.heroDad.navigation.graph.mainNavGraph
import com.journey.heroDad.ui.features.login.AppDestinationResolver
import com.journey.heroDad.ui.features.login.viewmodel.AuthState

enum class NavRoute {
    LOGIN,
    HOME_PAGE,
    DASHBOARD,
    TIMELINE,
    QUIZ,
    SETTINGS,
    PROFILE
}

enum class NavGraph{
    MAIN,
    AUTH
}

@Composable
fun MainNavigation(authState: AuthState) {

    val mainNavController = rememberNavController()
    val startDestinationGraph = remember {
        AppDestinationResolver.resolveAppDestination(authState = authState)
    }
    NavHost(navController = mainNavController, startDestination = startDestinationGraph) {
        authNavGraph(mainNavController)
        mainNavGraph(mainNavController)
    }
}