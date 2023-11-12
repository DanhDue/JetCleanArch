import extensions.*

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "splash")
}

android {
    namespace = "com.danhdue.jetcleanarch.presentation.splash"
}

dependencies {
    FRAMEWORK
    DOMAIN

    implementation(Deps.splashScreen)
}
