package com.journey.heroDad.ui.features.timeline.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journey.heroDad.ui.theme.Dimens
import com.journey.heroDad.utils.extensions.getBorderStroke

@Composable
fun TimelineCompletedCard(modifier: Modifier) {
    Surface(
        shape = RoundedCornerShape(Dimens.lg),
        color = Color(0xFF162330),
        border = MaterialTheme.getBorderStroke,
        tonalElevation = 0.dp,
        modifier = modifier
    ) {
        Column(modifier = modifier) {
            Text(
                "Completed".uppercase(),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W700
                )
            )
            Text(
                "Month 4: Second Trimester",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W600,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = .5f)
                )
            )
        }
    }
}