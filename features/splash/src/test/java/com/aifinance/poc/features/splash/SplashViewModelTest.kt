package com.aifinance.poc.features.splash

import app.cash.turbine.test
import com.aifinance.poc.features.splash.domain.SplashItem
import com.aifinance.poc.features.splash.domain.ObserveSplashUseCase
import com.aifinance.poc.features.splash.presentation.SplashScreenUiEvent
import com.aifinance.poc.features.splash.presentation.SplashViewModel
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
class SplashViewModelTest {

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
        val useCase = mockk<ObserveSplashUseCase>()
        every { useCase() } returns flowOf(
            Result.success(
                listOf(SplashItem(id = "1", title = "Coffee", subtitle = "$4.50")),
            ),
        )

        val viewModel = SplashViewModel(useCase)

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
        val useCase = mockk<ObserveSplashUseCase>()
        every { useCase() } returns flowOf(Result.success(emptyList()))
        val viewModel = SplashViewModel(useCase)
        viewModel.onEvent(SplashScreenUiEvent.Refresh)
        viewModel.uiState.test {
            val state = expectMostRecentItem()
            assertEquals(0, state.items.size)
            cancelAndIgnoreRemainingEvents()
        }
    }
}