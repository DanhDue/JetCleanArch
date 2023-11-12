package com.danhdue.jetcleanarch.presentation.dashboard.view

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danhdue.jetcleanarch.presentation.home.BottomBarHomeItem
import com.danhdue.jetcleanarch.presentation.home.HomeScreen
import com.danhdue.jetcleanarch.presentation.settings.SettingsScreen
import com.danhdue.jetcleanarch.providers.NavigationProvider
import com.danhdue.jetcleanarch.theme.JetCleanArchColors
import com.danhdue.jetcleanarch.theme.ralewayFonts
import com.danhdue.jetcleanarch.theme.selectedBottomItemColor
import com.danhdue.jetcleanarch.theme.unselectedBottomItemColor
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun DashboardContent(navigator: NavigationProvider? = null) {
    val scaffoldState = rememberScaffoldState()
    val (currentBottomTab, setCurrentBottomTab) = rememberSaveable {
        mutableStateOf(BottomBarHomeItem.HOME)
    }
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    Crossfade(currentBottomTab, label = "") { bottomTab ->
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = { BottomNavigation(bottomTab, setCurrentBottomTab) },
            content = {
                val modifier = Modifier.padding(it)
                when (bottomTab) {
                    BottomBarHomeItem.HOME -> HomeScreen(
                        navigator = navigator,
                        bottomSheetState = bottomSheetState
                    )
                    BottomBarHomeItem.SETTINGS -> SettingsScreen(
                        modifier = modifier,
                        navigator = navigator
                    )
                }
            }
        )
    }
}

@Composable
private fun BottomNavigation(
    bottomTab: BottomBarHomeItem,
    setCurrentBottomTab: (BottomBarHomeItem) -> Unit
) {
    val bottomBarHeight = 56.dp
    val pages = BottomBarHomeItem.values()

    BottomNavigation(
        backgroundColor = JetCleanArchColors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsHeight(bottomBarHeight)
    ) {
        pages.forEach { page ->
            val selected = page == bottomTab
            val selectedLabelColor = if (selected) {
                selectedBottomItemColor
            } else {
                unselectedBottomItemColor
            }
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = rememberVectorPainter(image = page.icon),
                        contentDescription = stringResource(page.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(page.title),
                        color = selectedLabelColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = ralewayFonts
                    )
                },
                selected = selected,
                onClick = {
                    setCurrentBottomTab.invoke(page)
                },
                selectedContentColor = selectedBottomItemColor,
                unselectedContentColor = unselectedBottomItemColor,
                alwaysShowLabel = true,
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }
}
