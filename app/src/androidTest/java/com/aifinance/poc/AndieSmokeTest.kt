package com.aifinance.poc

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Full instrumentation — one launch:
 * 1) walk every bottom-nav tab
 * 2) click known/tagged buttons (andie_btn_*, theme toggle)
 * 3) toggle dark mode when andie_theme_toggle is present
 */
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class AndieSmokeTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    private val tabRoutes = listOf(
        "addexpense",
        "analytics",
    )

    /** Stable tags stamped by Andie IR / theme chrome. */
    private val knownButtonTags = listOf(
        "andie_theme_toggle",
        "andie_btn_add_expense",
        "andie_btn_mic",
        "andie_btn_filter",
    )

    private val maxClicksPerScreen = 12

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun bottomNav_andAllButtons_smoke() {
        composeRule.onNodeWithTag("andie_root").assertIsDisplayed()

        if (tabRoutes.isNotEmpty()) {
            val firstNav = "andie_nav_" + tabRoutes.first()
            composeRule.waitUntil(timeoutMillis = 25_000) {
                try {
                    composeRule.onNodeWithTag(firstNav).fetchSemanticsNode()
                    true
                } catch (_: Throwable) {
                    false
                }
            }
        }

        clickIfPresent("andie_theme_toggle")

        for (route in tabRoutes) {
            val navTag = "andie_nav_$route"
            val screenTag = "andie_screen_$route"
            composeRule.onNodeWithTag(navTag).assertIsDisplayed().performClick()
            composeRule.waitForIdle()
            composeRule.onNodeWithTag(navTag).assertIsSelected()
            composeRule.onNodeWithTag(screenTag).assertIsDisplayed()
            clickButtonsOnCurrentScreen()
            composeRule.onNodeWithTag("andie_root").assertIsDisplayed()
        }

        if (tabRoutes.isEmpty()) {
            clickButtonsOnCurrentScreen()
            composeRule.onNodeWithTag("andie_root").assertIsDisplayed()
        }
    }

    private fun clickIfPresent(tag: String) {
        try {
            composeRule.onNodeWithTag(tag).assertIsDisplayed().performClick()
            composeRule.waitForIdle()
            composeRule.onNodeWithTag("andie_root").assertIsDisplayed()
        } catch (_: Throwable) {
            // Optional control — ignore.
        }
    }

    private fun clickButtonsOnCurrentScreen() {
        var clicks = 0
        for (tag in knownButtonTags) {
            if (clicks >= maxClicksPerScreen) return
            try {
                composeRule
                    .onNodeWithTag(tag, useUnmergedTree = true)
                    .assertIsDisplayed()
                    .performClick()
                composeRule.waitForIdle()
                clicks++
            } catch (_: Throwable) {
                // Soft — tag may be absent on this screen.
            }
        }
    }
}