package com.journey.heroDad.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.journey.heroDad.navigation.AppNavGraph
import com.journey.heroDad.navigation.AppNavRoute
import com.journey.heroDad.ui.features.login.screens.LoginScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = AppNavRoute.LOGIN_SCREEN.name,
        route = AppNavGraph.AUTH_GRAPH.name
    ) {
        composable(
            route = AppNavRoute.LOGIN_SCREEN.name
        ) {
            LoginScreen(navController = navController)
        }
    }
}