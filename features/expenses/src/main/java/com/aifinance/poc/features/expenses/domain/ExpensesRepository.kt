package com.aifinance.poc.features.expenses.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for expenses. */
interface ExpensesRepository {
    fun observeItems(): Flow<Result<List<ExpensesItem>>>
}