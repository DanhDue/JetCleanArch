package com.danhdue.jetcleanarch.presentation.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.danhdue.jetcleanarch.theme.R
enum class BottomBarHomeItem(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    HOME(
        title = R.string.bottom_menu_home,
        icon = Icons.Filled.Home
    ),
    SETTINGS(
        title = R.string.bottom_menu_settings,
        icon = Icons.Filled.Settings
    );
}