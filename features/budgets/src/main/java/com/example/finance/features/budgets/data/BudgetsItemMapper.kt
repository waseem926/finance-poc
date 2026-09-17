package com.example.finance.features.budgets.data

import com.example.finance.features.budgets.domain.BudgetsItem

internal fun BudgetsItemDto.toDomain(): BudgetsItem =
    BudgetsItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<BudgetsItemDto>.toDomain(): List<BudgetsItem> = map { it.toDomain() }