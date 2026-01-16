package com.journey.heroDad

import android.app.Application
import com.journey.heroDad.di.networkModule
import com.journey.heroDad.di.preferencesModule
import com.journey.heroDad.di.repositoryModule
import com.journey.heroDad.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class StarterApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@StarterApp)
            // Load modules
            modules(networkModule, repositoryModule, viewModelModule, preferencesModule)
        }
    }
}