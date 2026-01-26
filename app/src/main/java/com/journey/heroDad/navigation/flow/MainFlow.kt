package com.journey.heroDad.navigation.flow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.journey.heroDad.navigation.AppDestination
import com.journey.heroDad.navigation.BottomNavigationBar
import com.journey.heroDad.ui.features.dashboard.screens.DashboardScreen
import com.journey.heroDad.ui.features.home.screens.HomeScreen
import com.journey.heroDad.ui.features.quiz.screen.QuizScreen
import com.journey.heroDad.ui.features.settings.screens.SettingsScreen
import com.journey.heroDad.ui.features.timeline.TimelineScreen
import com.journey.heroDad.ui.theme.Dimens

@Composable
fun MainFlow() {
    val backStack = rememberNavBackStack(AppDestination.Home)
    val currentRoute = backStack.last() as AppDestination

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .padding(start = Dimens.lg, end = Dimens.lg, bottom = Dimens.xl)
                    .clip(
                        RoundedCornerShape(Dimens.lg)
                    )
                    .background(MaterialTheme.colorScheme.surface)
            ) {
                BottomNavigationBar(
                    currentDestination = currentRoute,
                    onTabSelected = { selectedRoute ->
                        backStack.clear()
                        backStack.add(selectedRoute)
                    }
                )
            }
        }
    ) {
        NavDisplay(
            backStack = backStack,
            onBack = {
                if (backStack.size > 1) {
                    backStack.removeLast()
                }
            },
            entryProvider = { key ->
                when (key) {
                    AppDestination.Home -> NavEntry(key) { HomeScreen() }
                    AppDestination.Dashboard -> NavEntry(key) { DashboardScreen() }
                    AppDestination.Timeline -> NavEntry(key) { TimelineScreen() }
                    AppDestination.Quiz -> NavEntry(key) { QuizScreen() }
                    AppDestination.Settings -> NavEntry(key) { SettingsScreen() }
                    else -> NavEntry(key) { HomeScreen() }
                }
            }
        )
    }
}