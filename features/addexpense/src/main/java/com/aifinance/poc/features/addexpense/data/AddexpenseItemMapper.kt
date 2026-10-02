package com.aifinance.poc.features.addexpense.data

import com.aifinance.poc.features.addexpense.domain.AddexpenseItem

internal fun AddexpenseItemDto.toDomain(): AddexpenseItem =
    AddexpenseItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<AddexpenseItemDto>.toDomain(): List<AddexpenseItem> = map { it.toDomain() }