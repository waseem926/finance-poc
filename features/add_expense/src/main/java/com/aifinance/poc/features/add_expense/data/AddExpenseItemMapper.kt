package com.aifinance.poc.features.add_expense.data

import com.aifinance.poc.features.add_expense.domain.AddExpenseItem

internal fun AddExpenseItemDto.toDomain(): AddExpenseItem =
    AddExpenseItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<AddExpenseItemDto>.toDomain(): List<AddExpenseItem> = map { it.toDomain() }