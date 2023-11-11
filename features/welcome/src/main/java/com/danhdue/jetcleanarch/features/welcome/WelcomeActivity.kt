package com.danhdue.jetcleanarch.features.welcome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.danhdue.jetcleanarch.features.welcome.navgraph.WelcomeNavGraph
import com.danhdue.jetcleanarch.jetframework.SetupSystemUi
import com.danhdue.jetcleanarch.providers.LanguageProvider
import com.danhdue.jetcleanarch.theme.JetCleanArchColors
import com.danhdue.jetcleanarch.theme.JetCleanArchTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeActivity: ComponentActivity() {
    @Inject
    lateinit var languageProvider: LanguageProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            languageProvider.setLocale(languageProvider.getLanguageCode(), LocalContext.current)
            WelcomeRoot()
        }
    }
}

@Composable
private fun WelcomeRoot() {
    JetCleanArchTheme {
        SetupSystemUi(rememberSystemUiController(), JetCleanArchColors.primary)
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = JetCleanArchColors.background
        ) { WelcomeNavGraph() }
    }
}
