plugins {
    id("commons.android-library")
    id("commons.android-compose")
}

android {
    namespace = "com.danhdue.jetcleanarch.theme"
}

dependencies { implementation(Deps.splashScreen) }