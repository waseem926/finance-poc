package com.aifinance.poc.features.history

import app.cash.turbine.test
import com.aifinance.poc.features.history.domain.HistoryItem
import com.aifinance.poc.features.history.domain.ObserveHistoryUseCase
import com.aifinance.poc.features.history.presentation.HistoryScreenUiEvent
import com.aifinance.poc.features.history.presentation.HistoryViewModel
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
class HistoryViewModelTest {

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
        val useCase = mockk<ObserveHistoryUseCase>()
        every { useCase() } returns flowOf(
            Result.success(
                listOf(HistoryItem(id = "1", title = "Coffee", subtitle = "$4.50")),
            ),
        )

        val viewModel = HistoryViewModel(useCase)

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
        val useCase = mockk<ObserveHistoryUseCase>()
        every { useCase() } returns flowOf(Result.success(emptyList()))
        val viewModel = HistoryViewModel(useCase)
        viewModel.onEvent(HistoryScreenUiEvent.Refresh)
        viewModel.uiState.test {
            val state = expectMostRecentItem()
            assertEquals(0, state.items.size)
            cancelAndIgnoreRemainingEvents()
        }
    }
}