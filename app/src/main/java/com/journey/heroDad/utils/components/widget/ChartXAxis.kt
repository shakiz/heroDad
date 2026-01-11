package com.journey.heroDad.utils.components.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ChartXAxis(points: List<ChartPoint>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        points.forEach {
            Text(
                text = it.label,
                color = Color(0xFF94A3B8),
                style =
                    MaterialTheme.typography.labelSmall
            )
        }
    }
}
