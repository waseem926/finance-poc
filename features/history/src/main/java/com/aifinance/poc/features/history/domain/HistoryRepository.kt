package com.aifinance.poc.features.history.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for history. */
interface HistoryRepository {
    fun observeItems(): Flow<Result<List<HistoryItem>>>
}