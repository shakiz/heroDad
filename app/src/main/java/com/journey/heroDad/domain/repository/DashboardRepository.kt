package com.journey.heroDad.domain.repository

import com.journey.heroDad.domain.model.recipes.Recipe
import com.journey.heroDad.domain.model.recipes.RecipeUser
import com.journey.heroDad.domain.model.user.User
import com.journey.heroDad.utils.components.network.ResultWrapper

interface DashboardRepository {
    suspend fun getUsers(): ResultWrapper<List<User>>
    suspend fun getRecipes(): ResultWrapper<List<Recipe>>
    suspend fun getRecipesByUser(): ResultWrapper<List<RecipeUser>>
}