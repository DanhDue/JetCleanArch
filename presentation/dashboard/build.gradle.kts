import extensions.*

plugins {
    id("commons.android-feature")
    id("commons.android-compose")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.presentation.dashboard"
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "dashboard")
}

dependencies {
    JETFRAMEWORK
    FRAMEWORK
    DOMAIN
    PROVIDER
    THEME
    COMPONENT

    FEATURE_HOME
    FEATURE_SETTINGS
}
