package com.aifinance.poc.features.analytics.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads AnalyticsScreen domain data for the POC. */
class ObserveExpenseAnalyticsUseCase @Inject constructor(
    private val repository: ExpenseRepository,
) {
    operator fun invoke(): Flow<Result<List<AnalyticsItem>>> = repository.observeItems()
}