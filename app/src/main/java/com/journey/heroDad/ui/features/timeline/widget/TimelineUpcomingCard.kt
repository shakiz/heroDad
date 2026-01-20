package com.journey.heroDad.ui.features.timeline.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journey.heroDad.R

@Composable
fun TimelineUpcomingCard(modifier: Modifier) {
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFF162330),
        border = BorderStroke(1.dp, Color(0xFF223347)),
        tonalElevation = 0.dp,
        modifier = modifier
    ) {
        Column(modifier = modifier) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Upcoming".uppercase(),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = .5f),
                        fontSize = 14.sp
                    )
                )
                Icon(
                    painter = painterResource(R.drawable.ic_lock),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
            }
            Text(
                "Month 6: Halfway There",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W600)
            )
            Text(
                "Focus on Hospital Planning and Classes",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = .5f),
                    fontSize = 14.sp
                )
            )
        }
    }
}