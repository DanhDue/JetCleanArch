package com.danhdue.jetcleanarch.features.welcome.onboarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.danhdue.jetcleanarch.domain.usecase.welcome.ReadOnBoarding
import com.danhdue.jetcleanarch.domain.usecase.welcome.SaveOnBoarding
import com.danhdue.jetcleanarch.features.welcome.navgraph.WelcomeScreen
import com.danhdue.jetcleanarch.framework.base.mvvm.MvvmViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val readOnBoarding: ReadOnBoarding,
    private val saveOnBoarding: SaveOnBoarding
): MvvmViewModel() {

    private val _startDestination: MutableState<String> =
        mutableStateOf(WelcomeScreen.OnBoarding.route)
    val startDestination: State<String> = _startDestination

    fun saveOnBoardingState(completed: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        val params = SaveOnBoarding.Params(completed)
        call(saveOnBoarding(params))
    }

    fun readOnBoardingState() = viewModelScope.launch {
        readOnBoarding(Unit).collect { completed ->
            if (completed) {
                _startDestination.value = WelcomeScreen.Environment.route
            } else {
                _startDestination.value = WelcomeScreen.OnBoarding.route
            }
        }
    }
}
