package com.journey.heroDad.ui.features.login.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.journey.heroDad.R
import com.journey.heroDad.navigation.NavGraph
import com.journey.heroDad.navigation.NavRoute
import com.journey.heroDad.ui.features.login.viewmodel.AuthState
import com.journey.heroDad.ui.features.login.viewmodel.AuthViewModel
import com.journey.heroDad.ui.features.login.widget.SocialLoginButton
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(authViewModel: AuthViewModel = koinViewModel(), navController: NavController) {
    val authUiState by authViewModel.authUiState.collectAsState()

    Scaffold(
        modifier = Modifier.background(color = MaterialTheme.colorScheme.onPrimary)
    ) { innerPadding ->
        Column {
            Column(
                modifier = Modifier
                    .padding(innerPadding.calculateStartPadding(layoutDirection = LayoutDirection.Ltr) + 16.dp)
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(32.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_security), // placeholder
                    contentDescription = null,
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Title
                Text(
                    text = "Let’s you in",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(32.dp))

                SocialLoginButton(
                    text = "Continue with Facebook",
                    icon = R.drawable.ic_facebook,
                    onClick = {
                        authViewModel.login()
                    }
                )

                SocialLoginButton(
                    text = "Continue with Google",
                    icon = R.drawable.ic_google,
                    onClick = {
                        authViewModel.login()
                    }
                )

                SocialLoginButton(
                    text = "Continue with Apple",
                    icon = R.drawable.ic_apple,
                    onClick = {
                        authViewModel.login()
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Divider
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "  or Log in with  ",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Primary button
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Phone Number / Email")
                }

                Spacer(modifier = Modifier.height(24.dp))
                when (authUiState.getOrNull()?.authState) {
                    is AuthState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    is AuthState.LoggedOut -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Error: ${authUiState.getOrNull()?.error}",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }

                    is AuthState.LoggedIn -> {
                        navController.navigate(
                            NavGraph.MAIN.name
                        ) {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }

                    else -> {}
                }
            }
        }
    }
}