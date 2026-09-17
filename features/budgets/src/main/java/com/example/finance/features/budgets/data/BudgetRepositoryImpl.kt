package com.example.finance.features.budgets.data

import com.example.finance.features.budgets.domain.BudgetsItem
import com.example.finance.features.budgets.domain.BudgetRepository
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
class BudgetRepositoryImpl @Inject constructor() : BudgetRepository {
    override fun observeItems(): Flow<Result<List<BudgetsItem>>> = flow {
        delay(300)
        val dtos = listOf(
            BudgetsItemDto(
                id = "1",
                title = "Food",
                subtitle = "$400",
            ),
            BudgetsItemDto(
                id = "2",
                title = "Transport",
                subtitle = "$120",
            ),
            BudgetsItemDto(
                id = "3",
                title = "Fun",
                subtitle = "$80",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}