package com.aifinance.poc.features.analytics.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads AnalyticsScreen domain data for the POC. */
class ObserveAnalyticsUseCase @Inject constructor(
    private val repository: AnalyticsRepository,
) {
    operator fun invoke(): Flow<Result<List<AnalyticsItem>>> = repository.observeItems()
}