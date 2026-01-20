package com.journey.heroDad.domain.model.quiz

data class Questions(
    val id: Int,
    val title: String,
    val hint: String,
    val questionType: QuestionType
)
