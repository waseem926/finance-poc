package com.example.finance.features.budgets.di

import com.example.finance.features.budgets.data.BudgetRepositoryImpl
import com.example.finance.features.budgets.domain.BudgetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Hilt bindings for `budgets`. */
@Module
@InstallIn(SingletonComponent::class)
abstract class BudgetsModule {
    @Binds
    @Singleton
    abstract fun bindBudgetRepository(
        impl: BudgetRepositoryImpl,
    ): BudgetRepository
}