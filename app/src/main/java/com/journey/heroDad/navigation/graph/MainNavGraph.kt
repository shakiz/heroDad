package com.journey.heroDad.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.journey.heroDad.navigation.MainScaffold
import com.journey.heroDad.navigation.NavGraph
import com.journey.heroDad.navigation.NavRoute

fun NavGraphBuilder.mainNavGraph(navController: NavController){
    navigation(
        startDestination = NavRoute.HOME_PAGE.name,
        route = NavGraph.HOME.name
    ){
        composable(
            route = NavRoute.HOME_PAGE.name
        ) {
            MainScaffold(navController = navController)
        }
    }
}