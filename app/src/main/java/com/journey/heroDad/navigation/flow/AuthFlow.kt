package com.journey.heroDad.navigation.flow

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.journey.heroDad.navigation.AppDestination
import com.journey.heroDad.ui.features.login.screens.LoginScreen

@Composable
fun AuthFlow(onLogin: () -> Unit) {
    val backStack = rememberNavBackStack(AppDestination.Login)

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLast()
        },
        entryProvider = { key ->
            when (key) {
                AppDestination.Login -> NavEntry(key) {
                    LoginScreen(onLogin = onLogin)
                }

                else -> NavEntry(key) {
                    LoginScreen(onLogin = onLogin)
                }
            }
        }
    )
}