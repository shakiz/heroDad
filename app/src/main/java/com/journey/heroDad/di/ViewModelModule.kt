package com.journey.heroDad.di

import com.journey.heroDad.ui.features.home.viewmodel.DashboardViewModel
import com.journey.heroDad.ui.features.quiz.viewmodel.QuizViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        DashboardViewModel(get())
    }
    viewModel {
        QuizViewModel()
    }
}