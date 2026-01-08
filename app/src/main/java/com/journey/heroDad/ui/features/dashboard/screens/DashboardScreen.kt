package com.journey.heroDad.ui.features.dashboard.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.journey.heroDad.R
import com.journey.heroDad.ui.features.dashboard.viewmodel.DashboardViewModel
import com.journey.heroDad.utils.components.network.ResultWrapper
import com.journey.heroDad.utils.components.widget.HeroDadAppBar
import com.journey.heroDad.utils.components.widget.StatCard
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    dashboardViewModel: DashboardViewModel = koinViewModel(),
    navController: NavController
) {
    val kicks by dashboardViewModel.kicks.collectAsState()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

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
                    Column {
                        //AppBar
                        HeroDadAppBar()
                        //Kick Count
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
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
                        StartKickCountCard()
                        KickList(result.data)
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

