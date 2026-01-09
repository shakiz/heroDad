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

    Scaffold() {innerPadding ->
        when(val result = kicks){
            ResultWrapper.Loading ->
                ResultWrapper.Success ->
            ResultWrapper.Failure - >
        }
    }
}