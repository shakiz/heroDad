package com.journey.heroDad.data.repository

import com.journey.heroDad.domain.model.todo.TodoData
import com.journey.heroDad.domain.repository.AuthRepository
import com.journey.heroDad.domain.service.AuthService
import com.journey.heroDad.ui.features.login.viewmodel.AuthState
import com.journey.heroDad.utils.components.pref.AuthPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthRepositoryImpl(
    private val authService: AuthService,
    private val authPreferences: AuthPreferences
) : AuthRepository {

    override suspend fun login(): Boolean {
        authPreferences.saveToken("token")
        return true
    }

    override suspend fun logout(): Boolean {
        val result = authPreferences.clearToken().isSuccess
        return result
    }

    override suspend fun getTodos(): TodoData {
        return authService.getTodos().let {
            it.body() as TodoData
        }
    }

    override fun getAuthToken(): Flow<AuthState> {
        return authPreferences.authTokenFlow.map { token ->
            if (token.isEmpty()) {
                AuthState.LoggedOut
            } else {
                AuthState.LoggedIn
            }
        }
    }
}