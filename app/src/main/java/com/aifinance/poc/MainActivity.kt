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
import com.aifinance.poc.core.ui.theme.ProvideThemeController
import com.aifinance.poc.core.ui.theme.rememberThemeController
import com.aifinance.poc.core.ui.theme.themeIsDark
import com.aifinance.poc.navigation.AppNavHost

/** Root activity hosting the Compose navigation graph. */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeController = rememberThemeController()
            ProvideThemeController(themeController) {
                AppTheme(darkTheme = themeIsDark(themeController)) {
                    Box(Modifier.testTag("andie_root")) {
                        AppNavHost()
                    }
                }
            }
        }
    }
}