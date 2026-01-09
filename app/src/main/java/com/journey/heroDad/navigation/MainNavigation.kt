package com.journey.heroDad.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.journey.heroDad.ui.features.dashboard.DashboardScreen
import com.journey.heroDad.ui.features.home.screens.HomeScreen
import com.journey.heroDad.ui.features.profile.ProfileScreen
import com.journey.heroDad.ui.features.quiz.QuizScreen
import com.journey.heroDad.ui.features.timeline.TimelineScreen
import com.journey.heroDad.utils.ScaleTransitionDirection
import com.journey.heroDad.utils.scaleIntoContainer
import com.journey.heroDad.utils.scaleOutOfContainer

enum class NavRoute {
    HOME,
    DASHBOARD,
    TIMELINE,
    QUIZ,
    PROFILE
}

@Composable
fun MainNavigation() {
    val mainNavController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController = mainNavController)
        }
    ) { innerPadding ->
        val graph = mainNavController.createGraph(
            startDestination = NavRoute.HOME.name
        ){
            composable(
                route = NavRoute.HOME.name,
                enterTransition = {
                    scaleIntoContainer()
                },
                exitTransition = {
                    scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
                },
            ) {
                HomeScreen(navController = mainNavController)
            }
            composable(
                route = NavRoute.DASHBOARD.name,
                enterTransition = {
                    scaleIntoContainer()
                },
                exitTransition = {
                    scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
                },
            ) {
                DashboardScreen()
            }
            composable(
                route = NavRoute.TIMELINE.name,
                enterTransition = {
                    scaleIntoContainer()
                },
                exitTransition = {
                    scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
                },
            ) {
                TimelineScreen()
            }
            composable(
                route = NavRoute.QUIZ.name,
                enterTransition = {
                    scaleIntoContainer()
                },
                exitTransition = {
                    scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
                },
            ) {
                QuizScreen()
            }
            composable(
                route = NavRoute.PROFILE.name,
                enterTransition = {
                    scaleIntoContainer()
                },
                exitTransition = {
                    scaleOutOfContainer(direction = ScaleTransitionDirection.INWARDS)
                },
            ) {
                ProfileScreen()
            }
        }
        NavHost(mainNavController, graph = graph, modifier = Modifier.padding(innerPadding))
    }
}