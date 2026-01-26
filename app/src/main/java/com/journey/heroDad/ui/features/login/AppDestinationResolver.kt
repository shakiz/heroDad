package com.journey.heroDad.ui.features.login

import com.journey.heroDad.navigation.AppDestination
import com.journey.heroDad.ui.features.login.viewmodel.AuthState

object AppDestinationResolver {
    fun resolveAppDestination(authState: AuthState): AppDestination {
        return when(authState) {
            is AuthState.LoggedIn -> AppDestination.Home
            is AuthState.LoggedOut -> AppDestination.Login
            else -> AppDestination.Login
        }
    }
}