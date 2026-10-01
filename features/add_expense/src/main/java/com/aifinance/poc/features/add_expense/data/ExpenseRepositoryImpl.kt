package com.aifinance.poc.features.add_expense.data

import com.aifinance.poc.features.add_expense.domain.AddExpenseItem
import com.aifinance.poc.features.add_expense.domain.ExpenseRepository
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
    override fun observeItems(): Flow<Result<List<AddExpenseItem>>> = flow {
        delay(300)
        val dtos = listOf(
            AddExpenseItemDto(
                id = "1",
                title = "Food & Dining",
                subtitle = "Add expense · sample 1",
            ),
            AddExpenseItemDto(
                id = "2",
                title = "Transport",
                subtitle = "Add expense · sample 2",
            ),
            AddExpenseItemDto(
                id = "3",
                title = "Bills & Utilities",
                subtitle = "Add expense · sample 3",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}