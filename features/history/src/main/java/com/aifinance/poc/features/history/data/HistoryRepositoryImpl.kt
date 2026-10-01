package com.aifinance.poc.features.history.data

import com.aifinance.poc.features.history.domain.HistoryItem
import com.aifinance.poc.features.history.domain.HistoryRepository
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
class HistoryRepositoryImpl @Inject constructor() : HistoryRepository {
    override fun observeItems(): Flow<Result<List<HistoryItem>>> = flow {
        delay(300)
        val dtos = listOf(
            HistoryItemDto(
                id = "1",
                title = "Mar 12 · Groceries · Whole Foods · −$42.50",
                subtitle = "History · sample 1",
            ),
            HistoryItemDto(
                id = "2",
                title = "Mar 11 · Transport · Uber · −$18.00",
                subtitle = "History · sample 2",
            ),
            HistoryItemDto(
                id = "3",
                title = "Mar 1 · Income · Salary · +$3,200.00",
                subtitle = "History · sample 3",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}