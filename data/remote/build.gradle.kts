import extensions.FRAMEWORK
import extensions.MODEL
import extensions.addNetworkDependencies

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.remote"
}

dependencies {
    FRAMEWORK
    MODEL

    // Network
    addNetworkDependencies()
}