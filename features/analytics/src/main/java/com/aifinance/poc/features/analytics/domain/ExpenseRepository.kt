package com.aifinance.poc.features.analytics.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for analytics. */
interface ExpenseRepository {
    fun observeItems(): Flow<Result<List<AnalyticsItem>>>
}