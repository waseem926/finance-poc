package com.finance.poc.features.splash.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads SplashScreen domain data for the POC. */
class ObserveSplashUseCase @Inject constructor(
    private val repository: SplashRepository,
) {
    operator fun invoke(): Flow<Result<List<SplashItem>>> = repository.observeItems()
}