package com.journey.heroDad.di

import com.journey.heroDad.data.repository.DashboardRepositoryImpl
import com.journey.heroDad.data.repository.LoginRepositoryImpl
import com.journey.heroDad.domain.repository.DashboardRepository
import com.journey.heroDad.domain.repository.LoginRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<LoginRepository> {  LoginRepositoryImpl(get()) }
    factory<DashboardRepository> {  DashboardRepositoryImpl(get()) }
}