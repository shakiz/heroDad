package com.journey.heroDad

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.journey.heroDad.navigation.MainNavigation
import com.journey.heroDad.ui.theme.HeroDadAppTheme
import com.journey.heroDad.utils.LanguageManager

class MainActivity : ComponentActivity() {
    override fun attachBaseContext(newBase: Context) {
        val languageManager = LanguageManager(newBase)
        super.attachBaseContext(languageManager.updateLocale(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeroDadAppTheme {
                MainNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DevicePreview() {
    HeroDadAppTheme {
        MainNavigation()
    }
}