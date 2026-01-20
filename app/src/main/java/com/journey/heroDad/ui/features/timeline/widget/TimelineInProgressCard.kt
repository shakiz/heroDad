package com.journey.heroDad.ui.features.timeline.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journey.heroDad.domain.model.timeline.TimelineProgressItem

@Composable
fun TimelineInProgressCard(modifier: Modifier) {
    val inProgressCheckListItem = listOf(
        TimelineProgressItem(title = "Schedule 20 week anatomy scan", isChecked = true),
        TimelineProgressItem(title = "Start researching pediatricians", isChecked = false),
        TimelineProgressItem(title = "Plan paternity leave", isChecked = false),
        TimelineProgressItem(title = "Assemble the crib", isChecked = false)
    )
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFF162330),
        border = BorderStroke(1.dp, Color(0xFF223347)),
        tonalElevation = 0.dp,
        modifier = modifier
    ) {
        Column(modifier = modifier) {
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0x204CAF50),
                border = BorderStroke(1.dp, Color(0xFF223347)),
                tonalElevation = 0.dp,
            ) {
                Text(
                    "Current Stage",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W700
                    ),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            Text(
                "Month 5: The Bump Appears",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W600)
            )
            Text(
                "The baby growing rapidly. You might feel the first kicks this month! It's time to start planning the practicalities.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.W400,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = .5f)
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Task Completed",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = .5f),
                        fontSize = 12.sp
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "1 of 4",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = .5f),
                        fontSize = 12.sp
                    )
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            LinearProgressIndicator(
                progress = { .6f },
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxWidth()
                    .height(8.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Column {
                inProgressCheckListItem.forEach { progressItem ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(
                            progressItem.isChecked,
                            onCheckedChange = null,
                            modifier = Modifier.clip(RoundedCornerShape(10.dp))
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            progressItem.title, style = MaterialTheme.typography.bodyMedium.copy(
                                color = if (progressItem.isChecked) {
                                    MaterialTheme.colorScheme.onPrimary.copy(alpha = .4f)
                                } else {
                                    MaterialTheme.colorScheme.onPrimary
                                }
                            )
                        )
                    }
                }
            }
        }
    }
}