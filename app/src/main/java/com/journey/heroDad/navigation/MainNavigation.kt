package com.journey.heroDad.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.journey.heroDad.navigation.graph.authNavGraph
import com.journey.heroDad.navigation.graph.mainNavGraph
import com.journey.heroDad.ui.features.login.AppDestinationResolver
import com.journey.heroDad.ui.features.login.viewmodel.AuthState

enum class AppNavRoute {
    LOGIN_SCREEN,
    HOME_SCREEN,
    DASHBOARD_SCREEN,
    TIMELINE_SCREEN,
    QUIZ_SCREEN,
    SETTINGS_SCREEN,
}

enum class AppNavGraph{
    MAIN_GRAPH,
    AUTH_GRAPH
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