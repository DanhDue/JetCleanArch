package commons

import Deps
import extensions.addHiltDependencies
import extensions.androidTestImplementation
import extensions.implementation
import extensions.testImplementation

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
}

dependencies { addHiltDependencies() }
