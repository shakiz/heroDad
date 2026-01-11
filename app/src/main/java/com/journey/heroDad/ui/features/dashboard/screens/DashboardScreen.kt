package com.journey.heroDad.ui.features.dashboard.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import com.journey.heroDad.R
import com.journey.heroDad.ui.features.dashboard.widget.KickTimeStatCard
import com.journey.heroDad.ui.features.home.viewmodel.DashboardViewModel
import com.journey.heroDad.ui.features.home.widget.KickListItem
import com.journey.heroDad.utils.components.network.ResultWrapper
import com.journey.heroDad.utils.components.widget.AppLineChartWidget
import org.koin.androidx.compose.navigation.koinNavViewModel

@Composable
fun DashboardScreen(dashboardViewModel: DashboardViewModel = koinNavViewModel()) {
    val uiState by dashboardViewModel.uiState.collectAsState()

    LaunchedEffect(Lifecycle.State.CREATED) {
        dashboardViewModel.getKicks()
        dashboardViewModel.getWeeklyKickData()
    }

    Scaffold { innerPadding ->
        when {
            uiState.kicks is ResultWrapper.Loading ||
                    uiState.weeklyKicks is ResultWrapper.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            uiState.kicks is ResultWrapper.Success && uiState.weeklyKicks is ResultWrapper.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 1. Static Headers as an item
                    item {
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                "Trends",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W900)
                            )
                            Text(
                                "Your baby's movement insights",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }

                    // 2. Stats Row as an item
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            KickTimeStatCard(
                                "Avg Duration",
                                R.drawable.ic_timer,
                                "14m",
                                Modifier.weight(1f)
                            )
                            KickTimeStatCard(
                                "Daily Avg",
                                R.drawable.ic_shuffle,
                                "2.4",
                                Modifier.weight(1f)
                            )
                        }
                    }

                    // 3. History Label
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("History", style = MaterialTheme.typography.titleMedium)
                            Text(
                                "View All",
                                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary)
                            )
                        }
                    }

                    // 4. IMPORTANT: Do not call KickList() if it contains a LazyColumn.
                    // Instead, extract its row logic directly here:

                    val kicks = uiState.kicks.getOrNull().orEmpty()
                    items(kicks.size) { pos ->
                        // REPLACE THIS with the individual row composable used inside KickList
                        KickListItem(kicks[pos])
                    }

                    // 5. Footer Chart as an item
                    item {
                        AppLineChartWidget(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            points = uiState.weeklyKicks.getOrNull().orEmpty()
                        )
                    }
                }
            }


            uiState.kicks is ResultWrapper.Failure ||
                    uiState.weeklyKicks is ResultWrapper.Failure -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Something Went Wrong",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}