package com.danhdue.jetcleanarch.features.welcome.onboarding

import androidx.annotation.DrawableRes
import com.danhdue.jetcleanarch.theme.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String) {
    data object First: OnBoardingPage(
        image = R.drawable.intro_1,
        title = "Characters",
        description = "You can access the list of characters and details."
    )

    data object Second : OnBoardingPage(
        image = R.drawable.intro_2,
        title = "Episodes",
        description = "You can access the list of episodes and details."
    )

    data object Third : OnBoardingPage(
        image = R.drawable.intro_3,
        title = "Locations",
        description = "You can access the list of locations and details."
    )
}