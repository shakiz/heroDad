package com.journey.heroDad.ui.features.quiz.widget

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
import com.journey.heroDad.ui.theme.Dimens
import com.journey.heroDad.utils.extensions.getBorderStroke

@Composable
fun QuizProgressCard() {
    Surface(
        shape = RoundedCornerShape(Dimens.lg),
        color = MaterialTheme.colorScheme.surface,
        border = MaterialTheme.getBorderStroke,
        tonalElevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(Dimens.lg)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Overall Progress",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.W700,
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                )
                Spacer(modifier = Modifier.width(Dimens.sm))
                Surface(
                    shape = RoundedCornerShape(Dimens.lg),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .1f),
                    border = MaterialTheme.getBorderStroke,
                    tonalElevation = 0.dp,
                ) {
                    Text(
                        "Level 3",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W700,
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(horizontal = Dimens.lg, vertical = Dimens.xs)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            LinearProgressIndicator(
                progress = { .4f },
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxWidth()
                    .height(Dimens.sm),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "3/10 Completed",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.W400,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                )
                Spacer(modifier = Modifier.width(Dimens.sm))
                Text(
                    "Keep going",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W700,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 12.sp
                    ),
                )
            }
        }
    }
}