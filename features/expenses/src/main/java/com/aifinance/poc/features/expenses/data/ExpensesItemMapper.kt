package com.aifinance.poc.features.expenses.data

import com.aifinance.poc.features.expenses.domain.ExpensesItem

internal fun ExpensesItemDto.toDomain(): ExpensesItem =
    ExpensesItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<ExpensesItemDto>.toDomain(): List<ExpensesItem> = map { it.toDomain() }