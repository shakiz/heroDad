package com.journey.heroDad

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.journey.heroDad.navigation.MainNavigation
import com.journey.heroDad.ui.features.login.viewmodel.AuthState
import com.journey.heroDad.ui.features.login.viewmodel.AuthViewModel
import com.journey.heroDad.ui.theme.HeroDadAppTheme
import com.journey.heroDad.utils.LanguageManager
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun attachBaseContext(newBase: Context) {
        val languageManager = LanguageManager(newBase)
        super.attachBaseContext(languageManager.updateLocale(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //KoinAndroidContext {
                HeroDadAppTheme {
//                    val authViewModel: AuthViewModel = koinViewModel()
//                    val authState by authViewModel.authState.collectAsState()
//
//                    // Optional splash/loading
//                    if (authState is AuthState.Loading) return@HeroDadAppTheme
                    MainNavigation(authState = AuthState.LoggedIn)
                }
            //}
        }
    }
}