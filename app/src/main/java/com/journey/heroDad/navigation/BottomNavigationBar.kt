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
import com.journey.heroDad.R
import com.journey.heroDad.ui.theme.Dimens

@Composable
fun BottomNavigationBar(
    currentDestination: AppDestination,
    onTabSelected: (AppDestination) -> Unit
) {
    val navigationItems = listOf(
        NavigationItem(
            title = "Home",
            icon = R.drawable.ic_home,
            route = AppDestination.Home
        ),
        NavigationItem(
            title = "Dashboard",
            icon = R.drawable.ic_dashboard,
            route = AppDestination.Dashboard
        ),
        NavigationItem(
            title = "Timeline",
            icon = R.drawable.ic_timeline,
            route = AppDestination.Timeline
        ),
        NavigationItem(
            title = "Quiz",
            icon = R.drawable.ic_exam,
            route = AppDestination.Quiz
        ),
        NavigationItem(
            title = "Settings",
            icon = R.drawable.ic_settings,
            route = AppDestination.Settings
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
            val isSelected = currentDestination == item.route
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    selectedIndex.intValue = index
                    onTabSelected(item.route)
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