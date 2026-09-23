package com.finance.poc.features.show_it_for_3_sec.data

import com.finance.poc.features.show_it_for_3_sec.domain.ShowItFor3SecItem

internal fun ShowItFor3SecItemDto.toDomain(): ShowItFor3SecItem =
    ShowItFor3SecItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<ShowItFor3SecItemDto>.toDomain(): List<ShowItFor3SecItem> = map { it.toDomain() }