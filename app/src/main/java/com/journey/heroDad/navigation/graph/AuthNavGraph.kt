package com.journey.heroDad.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.journey.heroDad.navigation.NavGraph
import com.journey.heroDad.navigation.NavRoute
import com.journey.heroDad.ui.features.login.screens.LoginScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = NavRoute.LOGIN.name,
        route = NavGraph.AUTH.name
    ) {
        composable(
            route = NavRoute.LOGIN.name
        ) {
            LoginScreen(navController = navController)
        }
    }
}