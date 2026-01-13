package com.journey.heroDad.ui.features.timeline

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.journey.heroDad.ui.features.timeline.widget.TimelineCompletedCard
import com.journey.heroDad.ui.features.timeline.widget.TimelineInProgressCard
import com.journey.heroDad.ui.features.timeline.widget.TimelineUpcomingCard

@Composable
fun TimelineScreen() {
    LazyColumn() {
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