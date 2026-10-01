package com.aifinance.poc.features.add_expense

import app.cash.turbine.test
import com.aifinance.poc.features.add_expense.domain.AddExpenseItem
import com.aifinance.poc.features.add_expense.domain.ObserveExpenseCategoriesUseCase
import com.aifinance.poc.features.add_expense.presentation.AddExpenseScreenUiEvent
import com.aifinance.poc.features.add_expense.presentation.AddExpenseViewModel
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
class AddExpenseViewModelTest {

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
        val useCase = mockk<ObserveExpenseCategoriesUseCase>()
        every { useCase() } returns flowOf(
            Result.success(
                listOf(AddExpenseItem(id = "1", title = "Coffee", subtitle = "$4.50")),
            ),
        )

        val viewModel = AddExpenseViewModel(useCase)

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
        val useCase = mockk<ObserveExpenseCategoriesUseCase>()
        every { useCase() } returns flowOf(Result.success(emptyList()))
        val viewModel = AddExpenseViewModel(useCase)
        viewModel.onEvent(AddExpenseScreenUiEvent.Refresh)
        viewModel.uiState.test {
            val state = expectMostRecentItem()
            assertEquals(0, state.items.size)
            cancelAndIgnoreRemainingEvents()
        }
    }
}