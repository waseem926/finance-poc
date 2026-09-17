package com.example.finance.features.transactions.domain

import kotlinx.coroutines.flow.Flow

/** Domain contract for transactions. */
interface TransactionRepository {
    fun observeItems(): Flow<Result<List<TransactionsItem>>>
}