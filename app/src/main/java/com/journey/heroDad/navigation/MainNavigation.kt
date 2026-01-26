package com.journey.heroDad.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.journey.heroDad.navigation.flow.AuthFlow
import com.journey.heroDad.navigation.flow.MainFlow
import com.journey.heroDad.ui.features.login.AppDestinationResolver
import com.journey.heroDad.ui.features.login.viewmodel.AuthState
import com.journey.heroDad.ui.features.login.viewmodel.AuthViewModel
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainNavigation(authState: AuthState) {
    val authViewModel: AuthViewModel = koinViewModel()

    KoinAndroidContext {
        val appDestination = remember {
            AppDestinationResolver.resolveAppDestination(authState = authState)
        }
        when(appDestination){
            AppDestination.Login -> AuthFlow()
            AppDestination.Home -> MainFlow(onLogout = {
                authViewModel.logout()
            })
            else -> AuthFlow()
        }
    }
}