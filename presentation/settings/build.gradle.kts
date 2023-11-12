import extensions.*

plugins {
    id("commons.android-feature")
    id("commons.android-compose")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.presentation.settings"
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "settings")
}

dependencies {
    JETFRAMEWORK
    FRAMEWORK
    DOMAIN
    PROVIDER
    THEME
    COMPONENT
}
