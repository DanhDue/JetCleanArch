package com.danhdue.jetcleanarch.presentation.dashboard

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.danhdue.jetcleanarch.presentation.dashboard.navgraph.RootNavGraph
import com.danhdue.jetcleanarch.presentation.dashboard.navgraph.RootNavigationProvider
import com.danhdue.jetcleanarch.jetframework.SetupSystemUi
import com.danhdue.jetcleanarch.providers.shouldUseDarkMode
import com.danhdue.jetcleanarch.theme.JetCleanArchColors
import com.danhdue.jetcleanarch.theme.JetCleanArchTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.utils.startDestination

@Composable
fun DashboardScreen(viewModel: DashboardViewModel = hiltViewModel(), finish: () -> Unit) {
    val navController = rememberNavController()

    val isDarkMode = viewModel.themeProvider().shouldUseDarkMode()

    val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()
    val destination = currentBackStackEntryAsState?.destination?.route
        ?: RootNavGraph.startRoute.startDestination.route

    if (destination == RootNavGraph.startRoute.startDestination.route) {
        BackHandler { finish() }
    }

    JetCleanArchTheme(darkTheme = isDarkMode) {
        SetupSystemUi(rememberSystemUiController(), JetCleanArchColors.primary)

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = JetCleanArchColors.background
        ) {
            DestinationsNavHost(
                navController = navController,
                navGraph = RootNavGraph,
                dependenciesContainerBuilder = {
                    dependency(RootNavigationProvider(navController))
                }
            )
        }
    }
}
