package com.aifinance.poc.features.analytics.di

import com.aifinance.poc.features.analytics.data.ExpenseRepositoryImpl
import com.aifinance.poc.features.analytics.domain.ExpenseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Hilt bindings for `analytics`. */
@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsModule {
    @Binds
    @Singleton
    abstract fun bindExpenseRepository(
        impl: ExpenseRepositoryImpl,
    ): ExpenseRepository
}