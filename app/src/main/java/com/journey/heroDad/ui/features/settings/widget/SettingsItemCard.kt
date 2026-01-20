package com.journey.heroDad.ui.features.settings.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.journey.heroDad.R
import com.journey.heroDad.domain.model.settings.SettingsItem
import com.journey.heroDad.ui.features.settings.screens.SettingsEnum
import com.journey.heroDad.ui.theme.Dimens

@Composable
fun SettingsItemCard(
    settingsItem: SettingsItem
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        Color(0x2F070918)
                    )
            ) {
                Icon(
                    painter = painterResource(settingsItem.icon),
                    contentDescription = "",
                    modifier = Modifier.padding(12.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = settingsItem.title,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        if (settingsItem.settingsEnum == SettingsEnum.THEME || settingsItem.settingsEnum == SettingsEnum.REMINDER) {
            Switch(
                checked = true,
                onCheckedChange = {

                }
            )
        } else {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_forward),
                contentDescription = "",
                modifier = Modifier
                    .padding(Dimens.md)
                    .size(Dimens.lg),
                tint = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}