package com.journey.heroDad.ui.features.home.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.journey.heroDad.domain.model.kick.Kick
import com.journey.heroDad.ui.features.dashboard.widget.KickHistoryListItem

@Composable
fun KickList(kickList: List<Kick>, isHistoryList: Boolean) {
    Column(modifier = Modifier.fillMaxSize()) {
        if (!isHistoryList) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Recent Sessions",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "View All",
                    style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary)
                )
            }
        }

        LazyColumn {
            if (isHistoryList) {
                items(kickList.size) { pos ->
                    KickHistoryListItem(kickList[pos])
                }
            } else {
                items(kickList.size) { pos ->
                    KickListItem(kickList[pos])
                }
            }
        }
    }
}