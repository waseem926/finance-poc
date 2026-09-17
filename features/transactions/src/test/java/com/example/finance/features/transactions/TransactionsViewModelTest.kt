package com.example.finance.features.transactions

import app.cash.turbine.test
import com.example.finance.features.transactions.domain.TransactionsItem
import com.example.finance.features.transactions.domain.ObserveTransactionsUseCase
import com.example.finance.features.transactions.presentation.TransactionsScreenUiEvent
import com.example.finance.features.transactions.presentation.TransactionsViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TransactionsViewModelTest {

    private val dispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `refresh loads domain items into ui state`() = runTest {
        val useCase = mockk<ObserveTransactionsUseCase>()
        every { useCase() } returns flowOf(
            Result.success(
                listOf(TransactionsItem(id = "1", title = "Coffee", subtitle = "$4.50")),
            ),
        )

        val viewModel = TransactionsViewModel(useCase)

        viewModel.uiState.test {
            val state = expectMostRecentItem()
            assertFalse(state.isLoading)
            assertEquals(1, state.items.size)
            assertEquals("Coffee", state.items.first().title)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `refresh event reloads`() = runTest {
        val useCase = mockk<ObserveTransactionsUseCase>()
        every { useCase() } returns flowOf(Result.success(emptyList()))
        val viewModel = TransactionsViewModel(useCase)
        viewModel.onEvent(TransactionsScreenUiEvent.Refresh)
        viewModel.uiState.test {
            val state = expectMostRecentItem()
            assertEquals(0, state.items.size)
            cancelAndIgnoreRemainingEvents()
        }
    }
}