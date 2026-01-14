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
import com.journey.heroDad.ui.features.dashboard.screens.DashboardScreen
import com.journey.heroDad.ui.features.home.screens.HomeScreen
import com.journey.heroDad.ui.features.profile.ProfileScreen
import com.journey.heroDad.ui.features.quiz.screen.QuizScreen
import com.journey.heroDad.ui.features.timeline.TimelineScreen

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
        ) {
            composable(
                route = NavRoute.HOME.name,
            ) {
                HomeScreen(navController = mainNavController)
            }
            composable(
                route = NavRoute.DASHBOARD.name,
            ) {
                DashboardScreen()
            }
            composable(
                route = NavRoute.TIMELINE.name,
            ) {
                TimelineScreen()
            }
            composable(
                route = NavRoute.QUIZ.name,
            ) {
                QuizScreen()
            }
            composable(
                route = NavRoute.PROFILE.name,
            ) {
                ProfileScreen()
            }
        }
        NavHost(mainNavController, graph = graph, modifier = Modifier.padding(innerPadding))
    }
}