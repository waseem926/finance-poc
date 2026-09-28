package com.aifinance.poc.features.expenses.di

import com.aifinance.poc.features.expenses.data.ExpensesRepositoryImpl
import com.aifinance.poc.features.expenses.domain.ExpensesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Hilt bindings for `expenses`. */
@Module
@InstallIn(SingletonComponent::class)
abstract class ExpensesModule {
    @Binds
    @Singleton
    abstract fun bindExpensesRepository(
        impl: ExpensesRepositoryImpl,
    ): ExpensesRepository
}