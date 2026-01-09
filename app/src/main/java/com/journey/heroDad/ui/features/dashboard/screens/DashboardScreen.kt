package com.journey.heroDad.ui.features.dashboard.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import com.journey.heroDad.R
import com.journey.heroDad.ui.features.dashboard.widget.KickTimeStatCard
import com.journey.heroDad.ui.features.home.viewmodel.DashboardViewModel
import com.journey.heroDad.ui.features.home.widget.KickList
import com.journey.heroDad.utils.components.network.ResultWrapper
import org.koin.androidx.compose.navigation.koinNavViewModel

@Composable
fun DashboardScreen(dashboardViewModel: DashboardViewModel = koinNavViewModel()) {
    val kicks by dashboardViewModel.kicks.collectAsState()
    LaunchedEffect(Lifecycle.State.CREATED) {
        if (kicks is ResultWrapper.Loading || kicks is ResultWrapper.Failure) {
            dashboardViewModel.getKicks()
        }
    }

    Scaffold() { innerPadding ->
        when (val result = kicks) {
            is ResultWrapper.Loading -> {

            }

            is ResultWrapper.Success -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Trends",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W900)
                        )
                        Text(
                            text = "Your baby's movement insights",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        KickTimeStatCard(
                            title = "Avg Duration",
                            icon = R.drawable.ic_timer,
                            value = "14m",
                            modifier = Modifier.weight(1f)
                        )
                        KickTimeStatCard(
                            title = "Daily Avg",
                            icon = R.drawable.ic_shuffle,
                            value = "2.4",
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = "History",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "View All",
                            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary)
                        )
                    }
                    KickList(result.data, isHistoryList = true)
                }
            }

            is ResultWrapper.Failure -> {

            }
        }
    }
}