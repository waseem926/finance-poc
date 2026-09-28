package com.aifinance.poc

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/** Application entry with Hilt dependency injection graph. */
@HiltAndroidApp
class App : Application()