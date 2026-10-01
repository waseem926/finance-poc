package com.aifinance.poc.features.add_expense.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads AddExpenseScreen domain data for the POC. */
class ObserveRecentExpensesUseCase @Inject constructor(
    private val repository: ExpenseRepository,
) {
    operator fun invoke(): Flow<Result<List<AddExpenseItem>>> = repository.observeItems()
}