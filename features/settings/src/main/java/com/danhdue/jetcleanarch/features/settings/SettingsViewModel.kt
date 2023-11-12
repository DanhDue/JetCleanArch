package com.danhdue.jetcleanarch.features.settings

import androidx.lifecycle.ViewModel
import com.danhdue.jetcleanarch.providers.ThemeProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val themeProvider: ThemeProvider
): ViewModel() {
    fun isNightMode() = themeProvider.isNightMode()

    fun saveThemeMode(isChecked: Boolean) {
        themeProvider.theme = if (isChecked) {
            ThemeProvider.Theme.DARK
        } else {
            ThemeProvider.Theme.LIGHT
        }
    }
}
