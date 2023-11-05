import extensions.FRAMEWORK
import extensions.addJsonParsingDependencies
import extensions.addRoomDependencies

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.model"
}

dependencies {
    FRAMEWORK
    // Moshi
    addJsonParsingDependencies()
    // Room
    addRoomDependencies()
}
