package com.journey.heroDad.ui.features.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journey.heroDad.domain.repository.AuthRepository
import com.journey.heroDad.utils.components.network.ResultWrapper
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

sealed interface AuthState {
    object LoggedOut : AuthState
    object LoggedIn : AuthState
    object IsFirstLaunch : AuthState
    object Loading : AuthState
}

data class AuthUiState(
    val authState: ResultWrapper<AuthState>
)

class AuthViewModel : ViewModel(), KoinComponent {
    val authRepository: AuthRepository = get()
    val authState: StateFlow<AuthState> =
        authRepository.getAuthToken()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = AuthState.Loading
            )
}