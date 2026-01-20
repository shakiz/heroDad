package com.journey.heroDad.ui.features.home.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journey.heroDad.R
import com.journey.heroDad.ui.theme.Dimens
import com.journey.heroDad.utils.extensions.getBorderStroke

@Composable
fun StatCard(
    title: String,
    value: String,
    subTitle: String,
    icon: Int,
    accentColor: Color,
    modifier: Modifier,
    isKickCount: Boolean
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(Dimens.lg),
        color = MaterialTheme.colorScheme.tertiary,
        border = MaterialTheme.getBorderStroke,
        tonalElevation = 0.dp
    ) {
        Column(
            modifier = Modifier.padding(Dimens.lg),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.W600
                )
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "",
                    tint = accentColor,
                    modifier = Modifier.size(18.dp)
                )
            }
            Text(
                text = value,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 20.sp,
                fontWeight = FontWeight.W900
            )

            Row {
                if (isKickCount) {
                    Icon(
                        painter = painterResource(R.drawable.ic_trend_up),
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp)
                            .padding(2.dp),
                        tint = accentColor
                    )
                }
                Text(
                    text = subTitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = accentColor
                )
            }
        }
    }
}