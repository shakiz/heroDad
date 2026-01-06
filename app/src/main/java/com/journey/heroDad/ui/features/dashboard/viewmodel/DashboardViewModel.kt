package com.journey.heroDad.ui.features.dashboard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journey.heroDad.domain.model.recipes.Recipe
import com.journey.heroDad.domain.model.recipes.RecipeUser
import com.journey.heroDad.domain.model.user.User
import com.journey.heroDad.domain.repository.DashboardRepository
import com.journey.heroDad.utils.components.network.ResultWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

// Note - Here we are passing the repo instance through constructor,
// because we wanted to explore this way of DI too.
// So you can wither access the repo by inject() from KoinComponent
// or declare the viewModelModule separately to provide the dependencies.
class DashboardViewModel(private val dashboardRepository: DashboardRepository) : ViewModel(), KoinComponent {

    private val _recipe = MutableStateFlow<ResultWrapper<List<Recipe>>>(ResultWrapper.Loading)
    val recipe: StateFlow<ResultWrapper<List<Recipe>>> = _recipe

    private val _users = MutableStateFlow<ResultWrapper<List<User>>>(ResultWrapper.Loading)
    val users: StateFlow<ResultWrapper<List<User>>> = _users

    private val _recipeUser = MutableStateFlow<ResultWrapper<List<RecipeUser>>>(ResultWrapper.Loading)
    val recipeUser: StateFlow<ResultWrapper<List<RecipeUser>>> = _recipeUser

    fun getRecipes() {
        viewModelScope.launch {
            _recipe.value = ResultWrapper.Loading
            _recipe.value = dashboardRepository.getRecipes()
        }
    }

    fun getUsers() {
        viewModelScope.launch {
            _users.value = ResultWrapper.Loading
            _users.value = dashboardRepository.getUsers()
        }
    }

    fun getRecipeUser() {
        viewModelScope.launch {
            _recipeUser.value = ResultWrapper.Loading
            _recipeUser.value = dashboardRepository.getRecipesByUser()
        }
    }
}
