package com.journey.heroDad.utils

class Utils {
    fun formatMillisToMinutesSeconds(millis: Long): String {
        val totalSeconds = millis / 1000
        val minutes = totalSeconds / 60
        val remainingSeconds = totalSeconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }
}