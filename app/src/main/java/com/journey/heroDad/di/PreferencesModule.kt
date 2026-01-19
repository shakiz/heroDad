package com.journey.heroDad.di

import com.journey.heroDad.utils.components.pref.AuthPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferencesModule = module {
    single {
        AuthPreferences(context = androidContext())
    }
}