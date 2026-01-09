package com.journey.heroDad.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = NavRoute.HOME.name
        ),
        NavigationItem(
            title = "Dashboard",
            icon = Icons.Default.DateRange,
            route = NavRoute.DASHBOARD.name
        ),
        NavigationItem(
            title = "Timeline",
            icon = Icons.Default.DateRange,
            route = NavRoute.TIMELINE.name
        ),
        NavigationItem(
            title = "Quiz",
            icon = Icons.Default.Info,
            route = NavRoute.QUIZ.name
        ),
        NavigationItem(
            title = "Profile",
            icon = Icons.Default.Person,
            route = NavRoute.PROFILE.name
        )

    )
    val selectedIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.onSurface
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex.intValue == index,
                onClick = {
                    selectedIndex.intValue = index
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        item.title,
                        color = if (index == selectedIndex.intValue)
                            Color.Black
                        else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surface,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}