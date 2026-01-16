package com.journey.heroDad.domain.repository

import com.journey.heroDad.domain.model.todo.TodoData
import com.journey.heroDad.ui.features.login.viewmodel.AuthState
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(): Boolean
    suspend fun logout()
    suspend fun getTodos() : TodoData

    fun getAuthToken(): Flow<AuthState>
}