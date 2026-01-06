package com.journey.heroDad.domain.service

import com.journey.heroDad.domain.model.recipes.RecipesBaseResponse
import com.journey.heroDad.domain.model.user.UserDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface DashboardService {
    @GET("recipes")
    suspend fun getRecipes(): Response<RecipesBaseResponse>

    @GET("users")
    suspend fun getUsers(): Response<UserDataResponse>
}