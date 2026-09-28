package com.aifinance.poc.features.splash.data

import com.aifinance.poc.features.splash.domain.SplashItem
import com.aifinance.poc.features.splash.domain.SplashRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Fake/local data source for POC.
 * Maps DTOs → domain models before leaving the data layer.
 */
@Singleton
class SplashRepositoryImpl @Inject constructor() : SplashRepository {
    override fun observeItems(): Flow<Result<List<SplashItem>>> = flow {
        delay(300)
        val dtos = listOf(
            SplashItemDto(
                id = "1",
                title = "App logo",
                subtitle = "Splash · sample 1",
            ),
            SplashItemDto(
                id = "2",
                title = "Loading…",
                subtitle = "Splash · sample 2",
            ),
            SplashItemDto(
                id = "3",
                title = "Continue",
                subtitle = "Splash · sample 3",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}