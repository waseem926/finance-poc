package com.finance.poc.features.show_it_for_3_sec.data

import com.finance.poc.features.show_it_for_3_sec.domain.ShowItFor3SecItem
import com.finance.poc.features.show_it_for_3_sec.domain.ShowItFor3SecRepository
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
class ShowItFor3SecRepositoryImpl @Inject constructor() : ShowItFor3SecRepository {
    override fun observeItems(): Flow<Result<List<ShowItFor3SecItem>>> = flow {
        delay(300)
        val dtos = listOf(
            ShowItFor3SecItemDto(
                id = "1",
                title = "ShowItFor3Sec item 1",
                subtitle = "ShowItFor3Sec · sample 1",
            ),
            ShowItFor3SecItemDto(
                id = "2",
                title = "ShowItFor3Sec item 2",
                subtitle = "ShowItFor3Sec · sample 2",
            ),
            ShowItFor3SecItemDto(
                id = "3",
                title = "ShowItFor3Sec item 3",
                subtitle = "ShowItFor3Sec · sample 3",
            ),
        )
        emit(Result.success(dtos.toDomain()))
    }
}