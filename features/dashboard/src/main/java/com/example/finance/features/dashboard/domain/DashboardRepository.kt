package com.example.finance.features.dashboard.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for dashboard. */
interface DashboardRepository {
    fun observeItems(): Flow<Result<List<DashboardItem>>>
}