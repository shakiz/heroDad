package com.journey.heroDad.ui.features.settings.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.journey.heroDad.R
import com.journey.heroDad.domain.model.settings.SettingsItem
import com.journey.heroDad.domain.repository.AuthRepository
import com.journey.heroDad.ui.features.settings.screens.SettingsEnum
import com.journey.heroDad.utils.components.network.ResultWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

data class SettingsUiState(
    val settingsItems: ResultWrapper<List<SettingsItem>> = ResultWrapper.Loading,
    val isLoggedOut: ResultWrapper<Boolean> = ResultWrapper.Success(false)
)

class SettingsVIewModel : ViewModel(), KoinComponent {
    private val authRepository: AuthRepository = get()
    private val _settingsItem =
        MutableStateFlow<ResultWrapper<List<SettingsItem>>>(ResultWrapper.Loading)
    private val _isLoggedOut =
        MutableStateFlow<ResultWrapper<Boolean>>(ResultWrapper.Success(false))

    val uiState = combine(_settingsItem, _isLoggedOut) { settingsItemResult, isLoggedOutResult ->
        SettingsUiState(settingsItems = settingsItemResult, isLoggedOut = isLoggedOutResult)
    }.stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SettingsUiState()
    )

    fun getSettingItem() {
        val localList = listOf(
            SettingsItem(
                icon = R.drawable.ic_notification,
                title = "Daily Reminders",
                settingsEnum = SettingsEnum.REMINDER
            ),
            SettingsItem(
                icon = R.drawable.ic_theme_mode,
                title = "Dark Mode",
                settingsEnum = SettingsEnum.THEME
            ),
            SettingsItem(
                icon = R.drawable.ic_export,
                title = "Export Kick History",
                settingsEnum = SettingsEnum.EXPORT_HISTORY
            ),
            SettingsItem(
                icon = R.drawable.ic_help,
                title = "Help & Guidelines",
                settingsEnum = SettingsEnum.HELP_AND_GUIDELINES
            ),
            SettingsItem(
                icon = R.drawable.ic_privacy,
                title = "Privacy Policy",
                settingsEnum = SettingsEnum.PRIVACY_POLICY
            ),
        )
        _settingsItem.value = ResultWrapper.Success(localList)
    }

    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
            authRepository.getAuthToken()
        }
    }
}