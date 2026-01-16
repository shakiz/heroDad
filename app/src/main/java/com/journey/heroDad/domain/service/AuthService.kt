package com.journey.heroDad.domain.service

import com.journey.heroDad.domain.model.todo.TodoData
import retrofit2.Response
import retrofit2.http.GET

interface AuthService {
    @GET("todos")
    suspend fun getTodos(): Response<TodoData>
}