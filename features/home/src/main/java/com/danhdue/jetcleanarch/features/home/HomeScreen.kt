package com.danhdue.jetcleanarch.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danhdue.jetcleanarch.components.widget.JCAToolbar
import com.danhdue.jetcleanarch.providers.NavigationProvider
import com.danhdue.jetcleanarch.theme.JetCleanArchTheme
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigator: NavigationProvider? = null,
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
) {
    HomeBody(modifier) {
        HomeContent()
    }
}

@Composable
private fun HomeBody(
    modifier: Modifier = Modifier,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = { JCAToolbar(com.danhdue.jetcleanarch.theme.R.string.toolbar_home_title) },
        content = { pageContent.invoke(it) }
    )
}

@Composable
private fun HomeContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to the Jet CleanArch",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JetCleanArchTheme { HomeScreen() }
}
