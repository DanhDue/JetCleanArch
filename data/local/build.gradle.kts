import extensions.FRAMEWORK
import extensions.MODEL
import extensions.addRoomDependencies

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.data.local"
}

dependencies {
    FRAMEWORK
    MODEL
    // Room
    addRoomDependencies()
}
