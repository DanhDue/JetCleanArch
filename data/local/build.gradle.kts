import extensions.FRAMEWORK
import extensions.MODEL

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.local"
}

dependencies {
    FRAMEWORK
    MODEL

    // Room
    implementation(Deps.Storage.roomKtx)
    ksp(Deps.Storage.roomCompiler)
}
