package com.aifinance.poc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import dagger.hilt.android.AndroidEntryPoint
import com.aifinance.poc.core.ui.theme.AppTheme
import com.aifinance.poc.navigation.AppNavHost

/** Root activity hosting the Compose navigation graph. */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Box(Modifier.testTag("andie_root")) {
                    AppNavHost()
                }
            }
        }
    }
}