package commons

import Deps
import extensions.addHiltDependencies
import extensions.androidTestImplementation
import extensions.implementation
import extensions.kapt
import extensions.testImplementation

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

dependencies { addHiltDependencies() }

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
