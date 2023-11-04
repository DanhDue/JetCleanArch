import extensions.JETFRAMEWORK
import extensions.THEME

plugins {
    id("commons.android-library")
    id("commons.android-compose")
}

android {
    namespace = "com.danhdue.jetcleanarch.components"
}

dependencies {
    THEME
    JETFRAMEWORK
}