package com.finance.poc.features.show_it_for_3_sec.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for show_it_for_3_sec. */
interface ShowItFor3SecRepository {
    fun observeItems(): Flow<Result<List<ShowItFor3SecItem>>>
}