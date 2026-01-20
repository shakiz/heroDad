package com.journey.heroDad.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = ColorPrimaryDark,
    secondary = ColorSecondaryDark,
    tertiary = ColorTertiaryDark,
    background = BackgroundPrimaryDark,
    surface = SurfacePrimaryDark,
    onPrimary = Color.White,
    onSecondary = SurfacePrimaryDark,
    onBackground = Color.White,
    onSurface = Color.White,
    error = ColorError,
    errorContainer = ColorErrorContainer
)

private val LightColorScheme = lightColorScheme(
    primary = ColorPrimaryLight,
    secondary = ColorSecondaryLight,
    tertiary = ColorTertiaryLight,
    background = BackgroundPrimaryLight,
    surface = SurfacePrimaryLight,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = OnTertiaryLight,
    onBackground = OnBackgroundLight,
    onSurface = OnSurfaceLight,
    error = ColorError,
    errorContainer = ColorErrorContainer,
)

@Composable
fun HeroDadAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = AppShapes,
            content = content
        )
    }
}