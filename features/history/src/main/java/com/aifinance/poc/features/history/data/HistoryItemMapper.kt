package com.aifinance.poc.features.history.data

import com.aifinance.poc.features.history.domain.HistoryItem

internal fun HistoryItemDto.toDomain(): HistoryItem =
    HistoryItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<HistoryItemDto>.toDomain(): List<HistoryItem> = map { it.toDomain() }