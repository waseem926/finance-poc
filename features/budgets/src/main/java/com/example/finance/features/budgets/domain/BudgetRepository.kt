package com.example.finance.features.budgets.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for budgets. */
interface BudgetRepository {
    fun observeItems(): Flow<Result<List<BudgetsItem>>>
}