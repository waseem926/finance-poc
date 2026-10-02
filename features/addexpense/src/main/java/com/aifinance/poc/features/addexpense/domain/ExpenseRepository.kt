package com.aifinance.poc.features.addexpense.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for addexpense. */
interface ExpenseRepository {
    fun observeItems(): Flow<Result<List<AddexpenseItem>>>
}