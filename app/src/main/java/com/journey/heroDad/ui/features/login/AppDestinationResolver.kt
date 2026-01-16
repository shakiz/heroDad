package com.journey.heroDad.ui.features.login

import com.journey.heroDad.navigation.NavGraph
import com.journey.heroDad.ui.features.login.viewmodel.AuthState

object AppDestinationResolver {
    fun resolveAppDestination(authState: AuthState): String {
        return when(authState) {
            is AuthState.LoggedIn -> NavGraph.HOME.name
            is AuthState.LoggedOut -> NavGraph.AUTH.name
            else -> NavGraph.AUTH.name
        }
    }
}