package com.aifinance.poc.features.add_expense.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for add_expense. */
interface ExpenseRepository {
    fun observeItems(): Flow<Result<List<AddExpenseItem>>>
}