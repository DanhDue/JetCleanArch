package com.danhdue.jetcleanarch.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val darkColorPalette = darkColors(
    primary = Blue,
    primaryVariant = Blue,
    onPrimary = White,
    secondary = Red,
    secondaryVariant = RedDark,
    onSecondary = Black,

    background = BackgroundDark,
    onBackground = BackgroundDark,

    surface = CardDark,
    onSurface = CardDark
)

@SuppressLint("ConflictingOnColor")
private val lightColorPalette = lightColors(
    primary = White,
    primaryVariant = Red,
    onPrimary = Black,
    secondary = Red,
    secondaryVariant = Red,
    onSecondary = Black,

    background = BackgroundLight,
    onBackground = BackgroundLight,

    surface = White,
    onSurface = White
)

val JetCleanArchColors: Colors
    @Composable get() = MaterialTheme.colors

val JetCleanArchShapes: Shapes
    @Composable get() = MaterialTheme.shapes

val JetCleanArchTypography: Typography
    @Composable get() = MaterialTheme.typography

@Composable
fun JetCleanArchTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    val typography = if (darkTheme) {
        darkTypography
    } else {
        lightTypography
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
