package com.finance.poc.features.show_it_for_3_sec.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads ShowItFor3SecScreen domain data for the POC. */
class ObserveShowItFor3SecUseCase @Inject constructor(
    private val repository: ShowItFor3SecRepository,
) {
    operator fun invoke(): Flow<Result<List<ShowItFor3SecItem>>> = repository.observeItems()
}