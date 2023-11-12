package com.danhdue.jetcleanarch.features.dashboard.navgraph

import com.danhdue.jetcleanarch.features.dashboard.view.DashboardNavGraph
import com.danhdue.jetcleanarch.features.home.HomeNavGraph
import com.danhdue.jetcleanarch.features.settings.SettingsNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

object RootNavGraph: NavGraphSpec {
    override val route: String = "root"

    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

    override val startRoute: Route = DashboardNavGraph

    override val nestedNavGraphs = listOf(DashboardNavGraph, HomeNavGraph, SettingsNavGraph)
}
