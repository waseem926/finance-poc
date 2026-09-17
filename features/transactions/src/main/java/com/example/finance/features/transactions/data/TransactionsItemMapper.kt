package com.example.finance.features.transactions.data

import com.example.finance.features.transactions.domain.TransactionsItem

internal fun TransactionsItemDto.toDomain(): TransactionsItem =
    TransactionsItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<TransactionsItemDto>.toDomain(): List<TransactionsItem> = map { it.toDomain() }