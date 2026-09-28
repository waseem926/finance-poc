package com.aifinance.poc.features.expenses.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads ExpensesScreen domain data for the POC. */
class ObserveExpensesUseCase @Inject constructor(
    private val repository: ExpensesRepository,
) {
    operator fun invoke(): Flow<Result<List<ExpensesItem>>> = repository.observeItems()
}