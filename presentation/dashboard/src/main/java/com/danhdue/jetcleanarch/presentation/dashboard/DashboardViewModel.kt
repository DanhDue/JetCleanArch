package com.danhdue.jetcleanarch.presentation.dashboard

import androidx.lifecycle.ViewModel
import com.danhdue.jetcleanarch.providers.ThemeProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val themeProvider: ThemeProvider): ViewModel() {

    fun themeProvider() = themeProvider
}