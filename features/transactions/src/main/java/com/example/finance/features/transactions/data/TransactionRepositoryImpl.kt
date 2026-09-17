package com.example.finance.features.transactions.data

import com.example.finance.features.transactions.domain.TransactionsItem
import com.example.finance.features.transactions.domain.TransactionRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Fake/local data source for POC.
 * Maps DTOs → domain models before leaving the data layer.
 */
@Singleton
class TransactionRepositoryImpl @Inject constructor() : TransactionRepository {
    override fun observeItems(): Flow<Result<List<TransactionsItem>>> = flow {
        delay(300)
        val dtos = listOf(
            TransactionsItemDto(
                id = "1",
                title = "Coffee",
                subtitle = "$4.50",
            ),
            TransactionsItemDto(
                id = "2",
                title = "Groceries",
                subtitle = "$62.10",
            ),
            TransactionsItemDto(
                id = "3",
                title = "Metro",
                subtitle = "$2.75",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}