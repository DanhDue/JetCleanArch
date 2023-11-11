package com.danhdue.jetcleanarch.features.welcome.navgraph

sealed class WelcomeScreen(val route: String) {
    data object OnBoarding: WelcomeScreen(route = ONBOARDING_SCREEN)
    data object Environment: WelcomeScreen(route = ENVIRONMENT_SCREEN)

    companion object {
        const val ONBOARDING_SCREEN = "ONBOARDING_SCREEN"
        const val ENVIRONMENT_SCREEN = "ENVIRONMENT_SCREEN"
    }
}