package com.example.finance.features.dashboard.data

import com.example.finance.features.dashboard.domain.DashboardItem
import com.example.finance.features.dashboard.domain.DashboardRepository
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
                title = "Spent this month",
                subtitle = "$1,240",
            ),
            DashboardItemDto(
                id = "2",
                title = "Budget left",
                subtitle = "$760",
            ),
            DashboardItemDto(
                id = "3",
                title = "Top category",
                subtitle = "Food",
            ),
            DashboardItemDto(
                id = "4",
                title = "Coffee",
                subtitle = "$4.50",
            ),
            DashboardItemDto(
                id = "5",
                title = "Groceries",
                subtitle = "$62.10",
            ),
            DashboardItemDto(
                id = "6",
                title = "Metro",
                subtitle = "$2.75",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}