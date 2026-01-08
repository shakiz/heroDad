package com.journey.heroDad.utils

class Utils {
    fun formatMillisToMinutesSeconds(milliseconds: Long): String {
        val totalSeconds = milliseconds / 1000
        val minutes = totalSeconds / 60
        val remainingSeconds = totalSeconds % 60
        return String.format("%dm %02ds", minutes, remainingSeconds)
    }
}