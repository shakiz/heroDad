package com.journey.heroDad.domain.model.quiz

data class Quiz(
    val id: Int,
    val title: String,
    val description: String,
    val questions: List<Questions>,
    val answers: List<Answers>
)
