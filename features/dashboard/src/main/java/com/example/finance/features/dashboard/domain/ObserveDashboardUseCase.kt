package com.example.finance.features.dashboard.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads DashboardScreen domain data for the POC. */
class ObserveDashboardUseCase @Inject constructor(
    private val repository: DashboardRepository,
) {
    operator fun invoke(): Flow<Result<List<DashboardItem>>> = repository.observeItems()
}