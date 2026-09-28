package com.aifinance.poc.features.analytics.data

import com.aifinance.poc.features.analytics.domain.AnalyticsItem

internal fun AnalyticsItemDto.toDomain(): AnalyticsItem =
    AnalyticsItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<AnalyticsItemDto>.toDomain(): List<AnalyticsItem> = map { it.toDomain() }