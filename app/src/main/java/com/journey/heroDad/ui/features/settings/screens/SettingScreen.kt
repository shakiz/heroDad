package com.journey.heroDad.ui.features.settings.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.journey.heroDad.R
import com.journey.heroDad.ui.features.settings.viewmodel.SettingsVIewModel
import com.journey.heroDad.ui.features.settings.widget.SettingsItemCard
import com.journey.heroDad.utils.components.network.ResultWrapper
import org.koin.androidx.compose.navigation.koinNavViewModel

enum class SettingsEnum {
    REMINDER,
    THEME,
    EXPORT_HISTORY,
    HELP_AND_GUIDELINES,
    PRIVACY_POLICY
}

@Composable
fun SettingsScreen(
    navController: NavController,
    settingsVIewModel: SettingsVIewModel = koinNavViewModel()
) {
    val uiState by settingsVIewModel.uiState.collectAsState()


    LaunchedEffect(Lifecycle.State.CREATED) {
        settingsVIewModel.getSettingItem()
    }

    Scaffold { innerPadding ->
        when (val result = uiState.settingsItems) {
            is ResultWrapper.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is ResultWrapper.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding.calculateStartPadding(layoutDirection = LayoutDirection.Ltr) + 16.dp)
                ) {
                    item {
                        Text(
                            "Profile",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W900)
                        )
                    }

                    item {
                        Surface(
                            color = MaterialTheme.colorScheme.tertiary,
                            shape = RoundedCornerShape(16.dp),
                            border = BorderStroke(1.dp, Color(0xFF223347)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 12.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .size(52.dp)
                                            .clip(RoundedCornerShape(16.dp))
                                            .background(
                                                MaterialTheme.colorScheme.surface
                                            )
                                    ) {
                                        Icon(
                                            painter = painterResource(R.drawable.ic_profile),
                                            contentDescription = "",
                                            modifier = Modifier.padding(12.dp),
                                            tint = MaterialTheme.colorScheme.secondary
                                        )
                                    }

                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.Start,
                                        modifier = Modifier.padding(horizontal = 12.dp)
                                    ) {
                                        Text(
                                            text = "Mark Stevens",
                                            style = MaterialTheme.typography.bodyLarge.copy(
                                                color = MaterialTheme.colorScheme.onPrimary,
                                                fontWeight = FontWeight.W600,
                                                fontSize = 14.sp
                                            )
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = "Due Date: 2 Months",
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                fontWeight = FontWeight.W300,
                                                fontSize = 14.sp
                                            )
                                        )
                                    }
                                }

                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                                    contentDescription = stringResource(R.string.add_recipe),
                                    tint = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }
                    }

                    item {
                        Text(
                            "Settings and Supports",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W900)
                        )
                    }

                    item {
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(MaterialTheme.colorScheme.tertiary)
                                .padding(vertical = 8.dp, horizontal = 16.dp)

                        ) {
                            result.data.forEach { item ->
                                SettingsItemCard(settingsItem = item)
                            }
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                    item {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = MaterialTheme.colorScheme.tertiary,
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.error),
                            tonalElevation = 0.dp,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.ic_logout),
                                    contentDescription = "",
                                    modifier = Modifier.size(24.dp),
                                    tint = MaterialTheme.colorScheme.error
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "Logout",
                                    style = MaterialTheme.typography.titleLarge.copy(
                                        fontWeight = FontWeight.W700,
                                        fontSize = 18.sp,
                                        color = MaterialTheme.colorScheme.error
                                    )
                                )
                            }
                        }
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