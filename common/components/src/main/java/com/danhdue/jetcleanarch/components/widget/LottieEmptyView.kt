package com.danhdue.jetcleanarch.components.widget

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danhdue.jetcleanarch.components.LottieView
import com.danhdue.jetcleanarch.theme.JetCleanArchTheme
import com.danhdue.jetcleanarch.theme.JetCleanArchTypography
import com.danhdue.jetcleanarch.theme.R

@Composable
fun LottieEmptyView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieView(
            file = "empty.json",
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(
            text = stringResource(id = R.string.text_no_data_found),
            style = JetCleanArchTypography.h3,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun LottieEmptyViewPreview() {
    JetCleanArchTheme { LottieEmptyView() }
}
