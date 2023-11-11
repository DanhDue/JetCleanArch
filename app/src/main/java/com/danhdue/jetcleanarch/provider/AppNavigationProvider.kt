package com.danhdue.jetcleanarch.provider

import androidx.navigation.NavController
import com.danhdue.jetcleanarch.providers.NavigationProvider

class AppNavigationProvider constructor(
    private val navController: NavController
) : NavigationProvider {
    override fun openTermAndPrivacy() {
        TODO("Not yet implemented")
    }

    override fun openAppLanguage() {
        TODO("Not yet implemented")
    }

    override fun openAbout() {
        TODO("Not yet implemented")
    }

    override fun navigateUp() {
        navController.navigateUp()
    }
}