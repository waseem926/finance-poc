package com.finance.poc.features.dashboard.data

import com.finance.poc.features.dashboard.domain.DashboardItem
import com.finance.poc.features.dashboard.domain.DashboardRepository
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
class DashboardRepositoryImpl @Inject constructor() : DashboardRepository {
    override fun observeItems(): Flow<Result<List<DashboardItem>>> = flow {
        delay(300)
        val dtos = listOf(
            DashboardItemDto(
                id = "1",
                title = "Dashboard item 1",
                subtitle = "Dashboard · sample 1",
            ),
            DashboardItemDto(
                id = "2",
                title = "Dashboard item 2",
                subtitle = "Dashboard · sample 2",
            ),
            DashboardItemDto(
                id = "3",
                title = "Dashboard item 3",
                subtitle = "Dashboard · sample 3",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}