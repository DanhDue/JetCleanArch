package com.danhdue.jetcleanarch.presentation.splash

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.danhdue.jetcleanarch.framework.extension.launchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StartActivity : ComponentActivity() {

    private val viewModel by viewModels<StartViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.startWelcome.collectLatest {
                    delay(WELCOME_DELAY_TIME)
                    if (it) navigateWelcomeActivity() else navigateDashboardActivity()
                }

            }
        }
    }

    private fun navigateDashboardActivity() {
        launchActivity(
            packageName = packageName,
            className = "com.danhdue.jetcleanarch.presentation.dashboard.DashboardActivity"
        ).also {
            finish()
        }
    }

    private fun navigateWelcomeActivity() {
        launchActivity(
            packageName = packageName,
            className = "com.danhdue.jetcleanarch.presentation.welcome.WelcomeActivity"
        ).also {
            finish()
        }
    }

    companion object {
        const val WELCOME_DELAY_TIME = 0L
    }
}
