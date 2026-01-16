package com.journey.heroDad.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.journey.heroDad.navigation.MainScaffold
import com.journey.heroDad.navigation.NavRoute

fun NavGraphBuilder.mainNavGraph(navController: NavController){
    navigation(
        startDestination = NavRoute.HOME.name,
        route = "main"
    ){
        composable(
            route = "home",
        ) {
            MainScaffold(navController = navController)
        }
    }
}