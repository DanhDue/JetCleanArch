package com.danhdue.jetcleanarch.features.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import com.danhdue.jetcleanarch.framework.extension.toast
import com.danhdue.jetcleanarch.providers.LanguageProvider
import com.danhdue.jetcleanarch.theme.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {
    @Inject
    lateinit var languageProvider: LanguageProvider

    private var backPressed = 0L

    private val finish: () -> Unit = {
        if (backPressed + QUIT_APP_DELAY_TIME > System.currentTimeMillis()) {
            finishAndRemoveTask()
        } else {
            toast(getString(R.string.app_exit_label))
        }
        backPressed = System.currentTimeMillis()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            languageProvider.setLocale(languageProvider.getLanguageCode(), LocalContext.current)
            DashboardScreen(finish = finish)
        }
    }

    companion object {
        const val QUIT_APP_DELAY_TIME = 3000L
    }
}
