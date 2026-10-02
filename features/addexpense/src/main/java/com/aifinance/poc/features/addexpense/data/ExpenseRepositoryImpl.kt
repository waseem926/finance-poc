package com.aifinance.poc.features.addexpense.data

import com.aifinance.poc.features.addexpense.domain.AddexpenseItem
import com.aifinance.poc.features.addexpense.domain.ExpenseRepository
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
class ExpenseRepositoryImpl @Inject constructor() : ExpenseRepository {
    override fun observeItems(): Flow<Result<List<AddexpenseItem>>> = flow {
        delay(300)
        val dtos = listOf(
            AddexpenseItemDto(
                id = "1",
                title = "Groceries · $42.50",
                subtitle = "Add Expense · sample 1",
            ),
            AddexpenseItemDto(
                id = "2",
                title = "Transport · $18.00",
                subtitle = "Add Expense · sample 2",
            ),
            AddexpenseItemDto(
                id = "3",
                title = "Coffee · $5.75",
                subtitle = "Add Expense · sample 3",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}