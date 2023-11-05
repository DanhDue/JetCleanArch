import extensions.*

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
    id("org.jetbrains.kotlin.android")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "splash")
}

android {
    namespace = "com.danhdue.jetcleanarch.splash"
}

dependencies {
    FRAMEWORK
    DOMAIN

    implementation(Deps.splashScreen)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}