package com.journey.heroDad.ui.features.home.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.journey.heroDad.R
import com.journey.heroDad.ui.features.home.viewmodel.DashboardViewModel
import com.journey.heroDad.ui.features.home.widget.KickListItem
import com.journey.heroDad.ui.features.home.widget.StartKickCountCard
import com.journey.heroDad.ui.features.home.widget.StatCard
import com.journey.heroDad.ui.theme.Dimens
import com.journey.heroDad.utils.components.network.ResultWrapper
import com.journey.heroDad.utils.components.widget.HeroDadAppBar
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    dashboardViewModel: DashboardViewModel = koinViewModel(),
    navController: NavController
) {
    val kicks by dashboardViewModel.kicks.collectAsState()

    // Fetch recipes if empty (only when the screen is first created)
    LaunchedEffect(Lifecycle.State.CREATED) {
        if (kicks is ResultWrapper.Loading || kicks is ResultWrapper.Failure) {
            dashboardViewModel.getKicks()
        }
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            when (val result = kicks) {
                is ResultWrapper.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is ResultWrapper.Success -> {
                    LazyColumn {
                        //AppBar
                        item {
                            HeroDadAppBar()
                        }
                        //Kick Count
                        item {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(Dimens.md),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = Dimens.lg)
                            ) {
                                StatCard(
                                    title = "TODAY'S KICKS",
                                    value = "12",
                                    subTitle = "On track",
                                    icon = R.drawable.ic_feet,
                                    accentColor = Color(0xFF4CAF50),
                                    modifier = Modifier.weight(1f),
                                    isKickCount = true
                                )

                                StatCard(
                                    title = "LAST SESSION",
                                    value = "14 min",
                                    subTitle = "Yesterday, 8:42 PM",
                                    icon = R.drawable.ic_timer,
                                    accentColor = Color(0xFFFFA726),
                                    modifier = Modifier.weight(1f),
                                    isKickCount = false
                                )
                            }
                        }
                        item {
                            StartKickCountCard()
                        }
                        item { Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimens.lg)
                        ) {
                            Text(
                                text = "Recent Sessions",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "View All",
                                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary)
                            )
                        } }
                        items(result.data.size) { pos ->
                            KickListItem(result.data[pos])
                        }
                    }
                }

                is ResultWrapper.Failure -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Error: ${result.message}",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        }
    }
}

