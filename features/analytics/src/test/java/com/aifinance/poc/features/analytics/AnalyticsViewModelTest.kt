package com.aifinance.poc.features.analytics

import app.cash.turbine.test
import com.aifinance.poc.features.analytics.domain.AnalyticsItem
import com.aifinance.poc.features.analytics.domain.ObserveAnalyticsUseCase
import com.aifinance.poc.features.analytics.presentation.AnalyticsScreenUiEvent
import com.aifinance.poc.features.analytics.presentation.AnalyticsViewModel
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
class AnalyticsViewModelTest {

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
        val useCase = mockk<ObserveAnalyticsUseCase>()
        every { useCase() } returns flowOf(
            Result.success(
                listOf(AnalyticsItem(id = "1", title = "Coffee", subtitle = "$4.50")),
            ),
        )

        val viewModel = AnalyticsViewModel(useCase)

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
        val useCase = mockk<ObserveAnalyticsUseCase>()
        every { useCase() } returns flowOf(Result.success(emptyList()))
        val viewModel = AnalyticsViewModel(useCase)
        viewModel.onEvent(AnalyticsScreenUiEvent.Refresh)
        viewModel.uiState.test {
            val state = expectMostRecentItem()
            assertEquals(0, state.items.size)
            cancelAndIgnoreRemainingEvents()
        }
    }
}