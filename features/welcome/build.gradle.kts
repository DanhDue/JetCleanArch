import extensions.*

plugins {
    id("commons.android-feature")
    id("commons.android-compose")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.features.welcome"
}

dependencies {
    JETFRAMEWORK
    FRAMEWORK
    DOMAIN
    PROVIDER
    THEME
    COMPONENT
}
