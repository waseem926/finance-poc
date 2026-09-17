package com.example.finance.features.budgets.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads BudgetsScreen domain data for the POC. */
class ObserveBudgetsUseCase @Inject constructor(
    private val repository: BudgetRepository,
) {
    operator fun invoke(): Flow<Result<List<BudgetsItem>>> = repository.observeItems()
}