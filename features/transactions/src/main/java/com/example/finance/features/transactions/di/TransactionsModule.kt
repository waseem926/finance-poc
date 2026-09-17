package com.example.finance.features.transactions.di

import com.example.finance.features.transactions.data.TransactionRepositoryImpl
import com.example.finance.features.transactions.domain.TransactionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Hilt bindings for `transactions`. */
@Module
@InstallIn(SingletonComponent::class)
abstract class TransactionsModule {
    @Binds
    @Singleton
    abstract fun bindTransactionRepository(
        impl: TransactionRepositoryImpl,
    ): TransactionRepository
}