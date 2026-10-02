package com.aifinance.poc.features.addexpense.di

import com.aifinance.poc.features.addexpense.data.ExpenseRepositoryImpl
import com.aifinance.poc.features.addexpense.domain.ExpenseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Hilt bindings for `addexpense`. */
@Module
@InstallIn(SingletonComponent::class)
abstract class AddexpenseModule {
    @Binds
    @Singleton
    abstract fun bindExpenseRepository(
        impl: ExpenseRepositoryImpl,
    ): ExpenseRepository
}