package com.journey.heroDad.domain.model.timeline

enum class TimelineStatus{
    COMPLETED,
    IN_PROGRESS,
    UPCOMING
}

data class TimelineCheckList(
    val id: Int,
    val title: String,
    val isChecked: Boolean
)

data class TimelineProgress(
    val id: Int,
    val title: String,
    val timelineStatus: TimelineStatus,
    val description: String,
    val timelineCheckList: TimelineCheckList
)