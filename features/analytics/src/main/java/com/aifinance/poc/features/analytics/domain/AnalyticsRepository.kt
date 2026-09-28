package com.aifinance.poc.features.analytics.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for analytics. */
interface AnalyticsRepository {
    fun observeItems(): Flow<Result<List<AnalyticsItem>>>
}