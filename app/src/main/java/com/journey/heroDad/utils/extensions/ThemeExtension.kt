package com.journey.heroDad.utils.extensions

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val MaterialTheme.getBorderStroke: BorderStroke?
    @Composable
    get() = if (isSystemInDarkTheme()){
        BorderStroke(1.dp, Color(0xFF223347))
    } else {
        null
    }