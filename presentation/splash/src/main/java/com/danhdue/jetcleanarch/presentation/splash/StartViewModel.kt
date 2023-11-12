package com.danhdue.jetcleanarch.presentation.splash

import com.danhdue.jetcleanarch.domain.usecase.welcome.ReadOnBoarding
import com.danhdue.jetcleanarch.framework.base.mvvm.MvvmViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val readOnBoarding: ReadOnBoarding
): MvvmViewModel() {

    private val _startWelcome = MutableStateFlow(false)
    val startWelcome = _startWelcome.asStateFlow()

    init {
        readOnBoardingState()
    }

    private fun readOnBoardingState() = safeLaunch {
        call(readOnBoarding(Unit)) { completed ->
            _startWelcome.value = !completed
        }
    }
}
