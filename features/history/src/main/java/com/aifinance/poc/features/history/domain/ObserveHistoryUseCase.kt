package com.aifinance.poc.features.history.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads HistoryScreen domain data for the POC. */
class ObserveHistoryUseCase @Inject constructor(
    private val repository: HistoryRepository,
) {
    operator fun invoke(): Flow<Result<List<HistoryItem>>> = repository.observeItems()
}