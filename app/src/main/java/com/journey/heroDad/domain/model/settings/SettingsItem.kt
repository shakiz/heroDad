package com.journey.heroDad.domain.model.settings

import com.journey.heroDad.ui.features.settings.screens.SettingsEnum

data class SettingsItem(
    val icon: Int,
    val title: String,
    val settingsEnum: SettingsEnum
)