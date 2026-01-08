package com.journey.heroDad.domain.model.kick

data class Kick(
    val id: Int,
    val noOfKicks: Int,
    val recordDate: String,
    val totalDuration: Long,
    val kickType: String
)
