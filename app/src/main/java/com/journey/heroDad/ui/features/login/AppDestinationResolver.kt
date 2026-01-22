package com.journey.heroDad.ui.features.login

import com.journey.heroDad.navigation.AppNavGraph
import com.journey.heroDad.ui.features.login.viewmodel.AuthState

object AppDestinationResolver {
    fun resolveAppDestination(authState: AuthState): String {
        return when(authState) {
            is AuthState.LoggedIn -> AppNavGraph.MAIN_GRAPH.name
            is AuthState.LoggedOut -> AppNavGraph.AUTH_GRAPH.name
            else -> AppNavGraph.AUTH_GRAPH.name
        }
    }
}