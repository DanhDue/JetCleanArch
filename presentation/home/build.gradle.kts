import extensions.*

plugins {
    id("commons.android-feature")
    id("commons.android-compose")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.presentation.home"
}

ksp {
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "home")
}

dependencies {
    JETFRAMEWORK
    FRAMEWORK
    DOMAIN
    PROVIDER
    THEME
    COMPONENT
}
