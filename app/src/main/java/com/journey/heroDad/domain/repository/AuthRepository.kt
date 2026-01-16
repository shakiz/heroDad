package com.journey.heroDad.domain.repository

import com.journey.heroDad.domain.model.todo.TodoData
import com.journey.heroDad.ui.features.login.viewmodel.AuthState
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun login()
    suspend fun logout()
    suspend fun getTodos() : TodoData

    fun getAuthToken(): Flow<AuthState>
}