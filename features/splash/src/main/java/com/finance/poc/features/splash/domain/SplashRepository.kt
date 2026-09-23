package com.finance.poc.features.splash.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for splash. */
interface SplashRepository {
    fun observeItems(): Flow<Result<List<SplashItem>>>
}