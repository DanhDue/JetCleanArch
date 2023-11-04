import extensions.FRAMEWORK
import extensions.LOCAL
import extensions.MODEL
import extensions.REMOTE
import extensions.addStorageDependencies

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.repository"
}

dependencies {
    FRAMEWORK
    MODEL
    LOCAL
    REMOTE

    addStorageDependencies()
}