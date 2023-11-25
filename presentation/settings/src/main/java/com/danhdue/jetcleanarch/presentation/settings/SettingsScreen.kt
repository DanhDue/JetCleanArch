package com.danhdue.jetcleanarch.presentation.settings

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.danhdue.jetcleanarch.components.widget.JCAToolbar
import com.danhdue.jetcleanarch.presentation.settings.view.SettingsContent
import com.danhdue.jetcleanarch.providers.NavigationProvider
import com.danhdue.jetcleanarch.theme.JetCleanArchTheme
import com.danhdue.jetcleanarch.theme.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
    navigator: NavigationProvider?
) {
    val checkedState = remember { mutableStateOf(viewModel.isNightMode()) }

    SettingsBody(modifier) { SettingsContent(viewModel, checkedState, navigator) }
}

@Composable
private fun SettingsBody(
    modifier: Modifier = Modifier, pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = { JCAToolbar(R.string.toolbar_settings_title) },
        content = { pageContent.invoke(it) },
    )
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun SettingsScreenPreview() {
    JetCleanArchTheme { Surface { SettingsBody {} } }
}
