package com.aifinance.poc.features.analytics.data

import com.aifinance.poc.features.analytics.domain.AnalyticsItem
import com.aifinance.poc.features.analytics.domain.AnalyticsRepository
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
class AnalyticsRepositoryImpl @Inject constructor() : AnalyticsRepository {
    override fun observeItems(): Flow<Result<List<AnalyticsItem>>> = flow {
        delay(300)
        val dtos = listOf(
            AnalyticsItemDto(
                id = "1",
                title = "Analytics item 1",
                subtitle = "Analytics · sample 1",
            ),
            AnalyticsItemDto(
                id = "2",
                title = "Analytics item 2",
                subtitle = "Analytics · sample 2",
            ),
            AnalyticsItemDto(
                id = "3",
                title = "Analytics item 3",
                subtitle = "Analytics · sample 3",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}