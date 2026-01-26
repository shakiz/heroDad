package com.journey.heroDad.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AppDestination : NavKey {
    @Serializable
    data object Login : AppDestination
    @Serializable data object Home : AppDestination
    @Serializable data object Dashboard : AppDestination
    @Serializable data object Timeline : AppDestination
    @Serializable data object Quiz : AppDestination
    @Serializable data object Settings : AppDestination
}