package com.journey.heroDad.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.journey.heroDad.ui.features.dashboard.screens.DashboardScreen
import com.journey.heroDad.ui.features.home.screens.HomeScreen
import com.journey.heroDad.ui.features.quiz.screen.QuizScreen
import com.journey.heroDad.ui.features.settings.screens.SettingsScreen
import com.journey.heroDad.ui.features.timeline.TimelineScreen
import com.journey.heroDad.ui.theme.Dimens

@Composable
fun MainScaffold(navController: NavController) {
    val mainNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Box (
                modifier = Modifier
                    .padding(start = Dimens.lg, end = Dimens.lg, bottom = Dimens.xl)
                    .clip(
                        RoundedCornerShape(Dimens.lg)
                    )
                    .background(MaterialTheme.colorScheme.surface)
            ){
                BottomNavigationBar(navController = mainNavController)
            }
        }
    ) { innerPadding ->
        NavHost(
            startDestination = NavRoute.HOME_PAGE.name,
            navController = mainNavController,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = NavRoute.HOME_PAGE.name,
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
                route = NavRoute.SETTINGS.name,
            ) {
                SettingsScreen(navController = mainNavController)
            }
        }
    }
}