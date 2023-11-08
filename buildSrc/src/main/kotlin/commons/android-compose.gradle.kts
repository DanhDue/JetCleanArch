package commons

import extensions.TEST
import extensions.addCommonDependencies
import extensions.addComposeDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android { addComposeConfig() }

dependencies {
    addCommonDependencies()
    addComposeDependencies()
    TEST
}
