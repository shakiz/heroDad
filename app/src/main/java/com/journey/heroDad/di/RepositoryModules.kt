package com.journey.heroDad.di

import com.journey.heroDad.data.repository.DashboardRepositoryImpl
import com.journey.heroDad.data.repository.AuthRepositoryImpl
import com.journey.heroDad.domain.repository.DashboardRepository
import com.journey.heroDad.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<AuthRepository> {  AuthRepositoryImpl(get(), get()) }
    factory<DashboardRepository> {  DashboardRepositoryImpl(get()) }
}