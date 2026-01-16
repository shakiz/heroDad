package com.journey.heroDad.utils.extensions

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.authDataStore by preferencesDataStore(name = "auth_prefs")