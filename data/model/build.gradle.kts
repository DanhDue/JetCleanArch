import extensions.FRAMEWORK

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
    implementation(Deps.Networking.moshi)
    ksp(Deps.Networking.moshiCodeGen)
    implementation(Deps.Networking.moshiLazyAdapter)

    // Room
    implementation(Deps.Storage.roomKtx)
    ksp(Deps.Storage.roomCompiler)
}
