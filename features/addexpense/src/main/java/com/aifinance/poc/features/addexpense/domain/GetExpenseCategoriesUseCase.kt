package com.aifinance.poc.features.addexpense.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads AddExpenseScreen domain data for the POC. */
class GetExpenseCategoriesUseCase @Inject constructor(
    private val repository: ExpenseRepository,
) {
    operator fun invoke(): Flow<Result<List<AddexpenseItem>>> = repository.observeItems()
}