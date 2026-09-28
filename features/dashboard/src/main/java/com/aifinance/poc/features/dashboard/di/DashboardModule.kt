package com.aifinance.poc.features.dashboard.di

import com.aifinance.poc.features.dashboard.data.DashboardRepositoryImpl
import com.aifinance.poc.features.dashboard.domain.DashboardRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Hilt bindings for `dashboard`. */
@Module
@InstallIn(SingletonComponent::class)
abstract class DashboardModule {
    @Binds
    @Singleton
    abstract fun bindDashboardRepository(
        impl: DashboardRepositoryImpl,
    ): DashboardRepository
}