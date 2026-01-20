package com.journey.heroDad.ui.features.dashboard.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journey.heroDad.R
import com.journey.heroDad.domain.model.kick.Kick
import com.journey.heroDad.ui.theme.Dimens
import com.journey.heroDad.utils.Utils
import com.journey.heroDad.utils.extensions.getBorderStroke

@Composable
fun KickHistoryListItem(kick: Kick) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(Dimens.lg),
        border = MaterialTheme.getBorderStroke,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.lg, vertical = Dimens.sm)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.lg, vertical = Dimens.md)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(52.dp)
                        .clip(RoundedCornerShape(Dimens.lg))
                        .background(
                            Color(0x2F070918)
                        )
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_click),
                        contentDescription = "",
                        modifier = Modifier.padding(Dimens.md),
                        tint = MaterialTheme.colorScheme.secondary
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(horizontal = Dimens.md)
                ) {
                    Text(
                        text = kick.recordDate,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = MaterialTheme.colorScheme.onSurface,
                            fontWeight = FontWeight.W600,
                            fontSize = 14.sp
                        )
                    )
                    Text(
                        text = "${Utils().formatMillisToMinutesSeconds(kick.totalDuration)} & ${kick.kickType}",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .5f),
                        )
                    )
                }
            }

            Column(
                modifier = Modifier.padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = kick.noOfKicks.toString(),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.W900
                    )
                )
                Text(
                    text = "Kicks".uppercase(),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontWeight = FontWeight.W700
                    )
                )
            }
        }
    }
}