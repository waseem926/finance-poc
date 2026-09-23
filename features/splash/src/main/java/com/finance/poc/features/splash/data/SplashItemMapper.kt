package com.finance.poc.features.splash.data

import com.finance.poc.features.splash.domain.SplashItem

internal fun SplashItemDto.toDomain(): SplashItem =
    SplashItem(
        id = id,
        title = title,
        subtitle = subtitle,
    )

internal fun List<SplashItemDto>.toDomain(): List<SplashItem> = map { it.toDomain() }