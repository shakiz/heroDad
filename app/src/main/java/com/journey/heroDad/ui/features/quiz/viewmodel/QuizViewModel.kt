package com.journey.heroDad.ui.features.quiz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journey.heroDad.R
import com.journey.heroDad.domain.model.quiz.QuizCategory
import com.journey.heroDad.utils.components.network.ResultWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

data class QuizUiState(
    val quizCategories: ResultWrapper<List<QuizCategory>> = ResultWrapper.Loading
)

class QuizViewModel() : ViewModel(),
    KoinComponent {
    private val _quizCategories =
        MutableStateFlow<ResultWrapper<List<QuizCategory>>>(ResultWrapper.Loading)
    val categories: StateFlow<ResultWrapper<List<QuizCategory>>> = _quizCategories

    val uiState: StateFlow<QuizUiState> = _quizCategories.map { quizCategoryResult ->
        QuizUiState(
            quizCategories = quizCategoryResult
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = QuizUiState()
    )

    fun getQuizCategories() {
        viewModelScope.launch {
            val localKickData = listOf(
                QuizCategory(
                    title = "Pregnancy Stages",
                    description = "Understanding Trimesters & Common Things",
                    icon = R.drawable.ic_calendar
                ),
                QuizCategory(
                    title = "Labor Prep",
                    description = "Hospital Bag& Logistics",
                    icon = R.drawable.ic_medicine_bag
                ),
                QuizCategory(
                    title = "Newborn Basics",
                    description = "Diapers, Swaddling, Sleep",
                    icon = R.drawable.ic_baby_face
                ),
                QuizCategory(
                    title = "Partner Support",
                    description = "How to support Mom effectively",
                    icon = R.drawable.ic_love
                ),
                QuizCategory(
                    title = "The Fourth Trimester",
                    description = "Postpartum Recover & Support",
                    icon = R.drawable.ic_infinity
                )
            )
            _quizCategories.value = ResultWrapper.Success(localKickData)
        }
    }
}
