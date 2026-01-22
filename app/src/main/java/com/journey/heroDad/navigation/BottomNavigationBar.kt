package com.journey.heroDad.navigation

import androidx.compose.foundation.layout.WindowInsets
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.journey.heroDad.R
import com.journey.heroDad.ui.theme.Dimens

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = R.drawable.ic_home,
            route = AppNavRoute.HOME_SCREEN.name
        ),
        NavigationItem(
            title = "Dashboard",
            icon = R.drawable.ic_dashboard,
            route = AppNavRoute.DASHBOARD_SCREEN.name
        ),
        NavigationItem(
            title = "Timeline",
            icon = R.drawable.ic_timeline,
            route = AppNavRoute.TIMELINE_SCREEN.name
        ),
        NavigationItem(
            title = "Quiz",
            icon = R.drawable.ic_exam,
            route = AppNavRoute.QUIZ_SCREEN.name
        ),
        NavigationItem(
            title = "Settings",
            icon = R.drawable.ic_settings,
            route = AppNavRoute.SETTINGS_SCREEN.name
        )

    )
    val selectedIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.secondary,
        windowInsets = WindowInsets(8, 0, 0, 8),
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex.intValue == index,
                onClick = {
                    selectedIndex.intValue = index
                    navController.navigate(item.route) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        modifier = Modifier.size(Dimens.iconSizeSmall),
                        tint = if (index == selectedIndex.intValue)
                            MaterialTheme.colorScheme.onSurface
                        else MaterialTheme.colorScheme.onSecondary
                    )
                },
                label = {
                    Text(
                        item.title,
                        fontSize = 11.sp,
                        color = if (index == selectedIndex.intValue)
                            MaterialTheme.colorScheme.onPrimary
                        else MaterialTheme.colorScheme.onSecondary
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onSurface,
                    indicatorColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    }
}