package com.journey.heroDad.ui.features.timeline

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journey.heroDad.ui.features.timeline.widget.TimelineCompletedCard
import com.journey.heroDad.ui.features.timeline.widget.TimelineInProgressCard
import com.journey.heroDad.ui.features.timeline.widget.TimelineUpcomingCard

@Composable
fun TimelineScreen() {
    LazyColumn() {
        item {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "Timeline",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W900),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Current Progress",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W400,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = .5f),
                            fontSize = 12.sp
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Month 5 of 9",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W400,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = .5f),
                            fontSize = 12.sp
                        )
                    )
                }
                LinearProgressIndicator(
                    progress = { .4f },
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxWidth()
                        .height(8.dp),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        item {
            TimelineCompletedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        item {
            TimelineInProgressCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        item {
            TimelineUpcomingCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}