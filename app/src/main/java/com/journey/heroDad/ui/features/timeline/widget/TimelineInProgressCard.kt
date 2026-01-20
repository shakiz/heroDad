package com.journey.heroDad.ui.features.timeline.widget

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journey.heroDad.domain.model.timeline.TimelineProgressItem
import com.journey.heroDad.ui.theme.ColorSuccessContainer
import com.journey.heroDad.ui.theme.Dimens
import com.journey.heroDad.utils.extensions.getBorderStroke

@Composable
fun TimelineInProgressCard(modifier: Modifier) {
    val inProgressCheckListItem = listOf(
        TimelineProgressItem(title = "Schedule 20 week anatomy scan", isChecked = true),
        TimelineProgressItem(title = "Start researching pediatricians", isChecked = false),
        TimelineProgressItem(title = "Plan paternity leave", isChecked = false),
        TimelineProgressItem(title = "Assemble the crib", isChecked = false)
    )
    Surface(
        shape = RoundedCornerShape(Dimens.lg),
        color = MaterialTheme.colorScheme.surface,
        border = MaterialTheme.getBorderStroke,
        tonalElevation = 0.dp,
        modifier = modifier
    ) {
        Column(modifier = modifier) {
            Surface(
                shape = RoundedCornerShape(Dimens.lg),
                color = ColorSuccessContainer,
                border = MaterialTheme.getBorderStroke,
                tonalElevation = 0.dp,
            ) {
                Text(
                    "Current Stage",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W700
                    ),
                    modifier = Modifier.padding(horizontal = Dimens.sm)
                )
            }
            Text(
                "Month 5: The Bump Appears",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W600)
            )
            Text(
                "The baby growing rapidly. You might feel the first kicks this month! It's time to start planning the practicalities.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.W400,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .5f)
                )
            )
            Spacer(modifier = Modifier.height(Dimens.sm))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Task Completed",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .5f),
                        fontSize = 12.sp
                    )
                )
                Spacer(modifier = Modifier.width(Dimens.sm))
                Text(
                    "1 of 4",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = .5f),
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
                    .height(Dimens.sm),
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
                                    MaterialTheme.colorScheme.onSurface.copy(alpha = .4f)
                                } else {
                                    MaterialTheme.colorScheme.onSurface
                                }
                            )
                        )
                    }
                }
            }
        }
    }
}