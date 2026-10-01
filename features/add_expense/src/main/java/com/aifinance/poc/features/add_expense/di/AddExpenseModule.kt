package com.aifinance.poc.features.add_expense.di

import com.aifinance.poc.features.add_expense.data.ExpenseRepositoryImpl
import com.aifinance.poc.features.add_expense.domain.ExpenseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Hilt bindings for `add_expense`. */
@Module
@InstallIn(SingletonComponent::class)
abstract class AddExpenseModule {
    @Binds
    @Singleton
    abstract fun bindExpenseRepository(
        impl: ExpenseRepositoryImpl,
    ): ExpenseRepository
}