import extensions.*

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.domain"
}

dependencies {
    FRAMEWORK
    MODEL
    LOCAL
    REMOTE
    REPOSITORY

    // Paging
    implementation(Deps.paging)
}
