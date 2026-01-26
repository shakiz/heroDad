package com.journey.heroDad.ui.features.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journey.heroDad.domain.repository.AuthRepository
import com.journey.heroDad.utils.components.network.ResultWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

sealed interface AuthState {
    object LoggedOut : AuthState
    object LoggedIn : AuthState
    object IsFirstLaunch : AuthState
    object Loading : AuthState
}

data class AuthUiState(
    val authState: AuthState,
    val isLoading: Boolean,
    val error: String
)

class AuthViewModel : ViewModel(), KoinComponent {
    val authRepository: AuthRepository = get()
    private val _authUiState = MutableStateFlow<ResultWrapper<AuthUiState>>(ResultWrapper.Loading)
    val authUiState: StateFlow<ResultWrapper<AuthUiState>> = _authUiState
    val authState: StateFlow<AuthState> =
        authRepository.getAuthToken()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = AuthState.Loading
            )

    fun login() {
        viewModelScope.launch {
            _authUiState.value = ResultWrapper.Success(
                AuthUiState(
                    authState = AuthState.Loading,
                    isLoading = true,
                    error = ""
                )
            )
            val isSuccess = authRepository.login()
            if (isSuccess) {
                _authUiState.value = ResultWrapper.Success(
                    AuthUiState(
                        authState = AuthState.LoggedIn,
                        isLoading = false,
                        error = ""
                    )
                )
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
            authRepository.getAuthToken()
        }
    }
}