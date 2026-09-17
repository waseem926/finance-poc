package com.example.finance.features.dashboard

import app.cash.turbine.test
import com.example.finance.features.dashboard.domain.DashboardItem
import com.example.finance.features.dashboard.domain.ObserveDashboardUseCase
import com.example.finance.features.dashboard.presentation.DashboardScreenUiEvent
import com.example.finance.features.dashboard.presentation.DashboardViewModel
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
class DashboardViewModelTest {

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
        val useCase = mockk<ObserveDashboardUseCase>()
        every { useCase() } returns flowOf(
            Result.success(
                listOf(DashboardItem(id = "1", title = "Coffee", subtitle = "$4.50")),
            ),
        )

        val viewModel = DashboardViewModel(useCase)

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
        val useCase = mockk<ObserveDashboardUseCase>()
        every { useCase() } returns flowOf(Result.success(emptyList()))
        val viewModel = DashboardViewModel(useCase)
        viewModel.onEvent(DashboardScreenUiEvent.Refresh)
        viewModel.uiState.test {
            val state = expectMostRecentItem()
            assertEquals(0, state.items.size)
            cancelAndIgnoreRemainingEvents()
        }
    }
}