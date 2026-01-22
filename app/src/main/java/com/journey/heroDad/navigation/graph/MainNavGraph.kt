package com.journey.heroDad.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.journey.heroDad.navigation.AppNavGraph
import com.journey.heroDad.navigation.AppNavRoute
import com.journey.heroDad.navigation.MainScaffold

fun NavGraphBuilder.mainNavGraph(navController: NavHostController){
    navigation(
        startDestination = AppNavRoute.HOME_SCREEN.name,
        route = AppNavGraph.MAIN_GRAPH.name
    ){
        composable(
            route = AppNavRoute.HOME_SCREEN.name
        ) {
            MainScaffold(navController = navController)
        }
    }
}