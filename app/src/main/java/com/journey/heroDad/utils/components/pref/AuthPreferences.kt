package com.journey.heroDad.utils.components.pref

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.journey.heroDad.utils.extensions.authDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthPreferences(
    private val context: Context
) {
    val authTokenFlow: Flow<String> = context.authDataStore.data.map { prefs ->
        prefs[AuthPrefKeys.AUTH_TOKEN].orEmpty()
    }

    suspend fun saveToken(token: String){
        context.authDataStore.edit { prefs ->
            prefs[AuthPrefKeys.AUTH_TOKEN] = token
        }
    }

    suspend fun clearToken(){
        context.authDataStore.edit { prefs ->
            prefs.remove(AuthPrefKeys.AUTH_TOKEN)
        }
    }
}