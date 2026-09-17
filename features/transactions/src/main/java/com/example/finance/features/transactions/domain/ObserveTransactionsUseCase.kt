package com.example.finance.features.transactions.domain

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Loads TransactionsScreen domain data for the POC. */
class ObserveTransactionsUseCase @Inject constructor(
    private val repository: TransactionRepository,
) {
    operator fun invoke(): Flow<Result<List<TransactionsItem>>> = repository.observeItems()
}