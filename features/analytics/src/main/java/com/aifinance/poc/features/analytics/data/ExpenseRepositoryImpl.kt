package com.aifinance.poc.features.analytics.data

import com.aifinance.poc.features.analytics.domain.AnalyticsItem
import com.aifinance.poc.features.analytics.domain.ExpenseRepository
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
    override fun observeItems(): Flow<Result<List<AnalyticsItem>>> = flow {
        delay(300)
        val dtos = listOf(
            AnalyticsItemDto(
                id = "1",
                title = "Food & Dining · 32% · $412",
                subtitle = "Analytics · sample 1",
            ),
            AnalyticsItemDto(
                id = "2",
                title = "Transport · 18% · $231",
                subtitle = "Analytics · sample 2",
            ),
            AnalyticsItemDto(
                id = "3",
                title = "Shopping · 15% · $193",
                subtitle = "Analytics · sample 3",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}