package com.aifinance.poc.features.expenses.data

import com.aifinance.poc.features.expenses.domain.ExpensesItem
import com.aifinance.poc.features.expenses.domain.ExpensesRepository
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
class ExpensesRepositoryImpl @Inject constructor() : ExpensesRepository {
    override fun observeItems(): Flow<Result<List<ExpensesItem>>> = flow {
        delay(300)
        val dtos = listOf(
            ExpensesItemDto(
                id = "1",
                title = "Expenses item 1",
                subtitle = "Expenses · sample 1",
            ),
            ExpensesItemDto(
                id = "2",
                title = "Expenses item 2",
                subtitle = "Expenses · sample 2",
            ),
            ExpensesItemDto(
                id = "3",
                title = "Expenses item 3",
                subtitle = "Expenses · sample 3",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}