package com.journey.heroDad.navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.journey.heroDad.R

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = R.drawable.ic_home,
            route = NavRoute.HOME.name
        ),
        NavigationItem(
            title = "Dashboard",
            icon = R.drawable.ic_dashboard,
            route = NavRoute.DASHBOARD.name
        ),
        NavigationItem(
            title = "Timeline",
            icon = R.drawable.ic_timeline,
            route = NavRoute.TIMELINE.name
        ),
        NavigationItem(
            title = "Quiz",
            icon = R.drawable.ic_exam,
            route = NavRoute.QUIZ.name
        ),
        NavigationItem(
            title = "Settings",
            icon = R.drawable.ic_settings,
            route = NavRoute.SETTINGS.name
        )

    )
    val selectedIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.tertiary
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
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(20.dp)
                    )
                },
                label = {
                    Text(
                        item.title,
                        color = if (index == selectedIndex.intValue)
                            MaterialTheme.colorScheme.onPrimary
                        else Color.Gray
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.secondary,
                    indicatorColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}