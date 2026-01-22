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
import androidx.navigation.NavHostController
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
            startDestination = AppNavRoute.HOME_SCREEN.name,
            navController = mainNavController,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = AppNavRoute.HOME_SCREEN.name,
            ) {
                HomeScreen(navController = mainNavController)
            }
            composable(
                route = AppNavRoute.DASHBOARD_SCREEN.name,
            ) {
                DashboardScreen()
            }
            composable(
                route = AppNavRoute.TIMELINE_SCREEN.name,
            ) {
                TimelineScreen()
            }
            composable(
                route = AppNavRoute.QUIZ_SCREEN.name,
            ) {
                QuizScreen()
            }
            composable(
                route = AppNavRoute.SETTINGS_SCREEN.name,
            ) {
                SettingsScreen(navController = mainNavController)
            }
        }
    }
}