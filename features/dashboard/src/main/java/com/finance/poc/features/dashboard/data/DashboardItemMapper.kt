package com.finance.poc.features.dashboard.data

import com.finance.poc.features.dashboard.domain.DashboardItem

internal fun DashboardItemDto.toDomain(): DashboardItem =
    DashboardItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<DashboardItemDto>.toDomain(): List<DashboardItem> = map { it.toDomain() }