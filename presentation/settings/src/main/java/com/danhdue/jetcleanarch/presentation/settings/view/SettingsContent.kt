@file:Suppress("LongMethod")

package com.danhdue.jetcleanarch.presentation.settings.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.content.ContextCompat.getString
import androidx.hilt.navigation.compose.hiltViewModel
import com.danhdue.jetcleanarch.components.widget.JCADivider
import com.danhdue.jetcleanarch.components.widget.ThemeSwitch
import com.danhdue.jetcleanarch.framework.extension.appVersion
import com.danhdue.jetcleanarch.framework.extension.toast
import com.danhdue.jetcleanarch.jetframework.clickableSingle
import com.danhdue.jetcleanarch.presentation.settings.SettingsViewModel
import com.danhdue.jetcleanarch.providers.NavigationProvider
import com.danhdue.jetcleanarch.theme.Gray400
import com.danhdue.jetcleanarch.theme.JetCleanArchTheme
import com.danhdue.jetcleanarch.theme.JetCleanArchTypography
import com.danhdue.jetcleanarch.theme.R

@Composable
fun SettingsContent(
    viewModel: SettingsViewModel = hiltViewModel(),
    checkedState: MutableState<Boolean>,
    navigator: NavigationProvider? = null
) {
    val context = LocalContext.current
    val version = context.appVersion()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                val (
                    lblThemeMode,
                    switchThemeMode,
                    viewDivider1,
                    lblRateApp,
                    viewDivider2,
                    lblShareApp,
                    viewDivider3,
                    lblTermAndPrivacy,
                    viewDivider4,
                    lblAppLanguage,
                    viewDivider5,
                    lblAbout,
                    viewDivider6,
                    lblAppVersion,
                    tvAppVersion
                ) = createRefs()

                Text(
                    text = stringResource(id = R.string.text_theme_mode),
                    style = JetCleanArchTypography.body2,
                    modifier = Modifier.constrainAs(lblThemeMode) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                )

                AndroidView(
                    factory = { context ->
                        ThemeSwitch(context).apply {
                            isChecked = checkedState.value
                            setOnCheckedChangeListener { _, isChecked ->
                                checkedState.value = isChecked
                                viewModel.saveThemeMode(isChecked)
                            }
                        }
                    },
                    modifier = Modifier.constrainAs(switchThemeMode) {
                        top.linkTo(lblThemeMode.top)
                        bottom.linkTo(lblThemeMode.bottom)
                        end.linkTo(parent.end)
                    }
                )

                JCADivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider1) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblThemeMode.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Text(
                    text = stringResource(id = R.string.text_rate_app),
                    style = JetCleanArchTypography.body2,
                    modifier = Modifier
                        .constrainAs(lblRateApp) {
                            top.linkTo(viewDivider1.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            context.toast(getString(context, R.string.text_this_feature_is_developing))
                        }
                )

                JCADivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider2) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblRateApp.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Text(
                    text = stringResource(id = R.string.text_share_app),
                    style = JetCleanArchTypography.body2,
                    modifier = Modifier
                        .constrainAs(lblShareApp) {
                            top.linkTo(viewDivider2.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            context.toast(getString(context, R.string.text_this_feature_is_developing))
                        }
                )

                JCADivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider3) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblShareApp.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Row(
                    modifier = Modifier
                        .constrainAs(lblTermAndPrivacy) {
                            top.linkTo(viewDivider3.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            context.toast(getString(context, R.string.text_this_feature_is_developing))

                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.text_term_and_privacy),
                        style = JetCleanArchTypography.body2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    Icon(
                        painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.wrapContentSize()
                    )
                }

                JCADivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider4) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblTermAndPrivacy.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Row(
                    modifier = Modifier
                        .constrainAs(lblAppLanguage) {
                            top.linkTo(viewDivider4.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            context.toast(getString(context, R.string.text_this_feature_is_developing))
                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.text_app_language),
                        style = JetCleanArchTypography.body2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    Icon(
                        painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.wrapContentSize()
                    )
                }

                JCADivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider5) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblAppLanguage.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Row(
                    modifier = Modifier
                        .constrainAs(lblAbout) {
                            top.linkTo(viewDivider5.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            context.toast(getString(context, R.string.text_this_feature_is_developing))
                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.text_about),
                        style = JetCleanArchTypography.body2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    Icon(
                        painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.wrapContentSize()
                    )
                }

                JCADivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider6) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblAbout.bottom)
                            height = Dimension.fillToConstraints
                        }
                )

                Text(
                    text = stringResource(id = R.string.text_app_version),
                    style = JetCleanArchTypography.body2,
                    modifier = Modifier.constrainAs(lblAppVersion) {
                        top.linkTo(viewDivider6.bottom)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                )

                Text(
                    text = version,
                    style = JetCleanArchTypography.subtitle1,
                    modifier = Modifier.constrainAs(tvAppVersion) {
                        top.linkTo(lblAppVersion.top)
                        bottom.linkTo(lblAppVersion.bottom)
                        end.linkTo(parent.end)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsContentPreview() {
    JetCleanArchTheme {
        val checkedState = remember {
            mutableStateOf(true)
        }
        SettingsContent(checkedState = checkedState)
    }
}
