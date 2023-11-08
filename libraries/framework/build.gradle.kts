import extensions.addFirebaseDependencies
import extensions.addNetworkDependencies
import extensions.addStorageDependencies
import extensions.implementation

plugins {
    id("commons.android-library")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.danhdue.jetcleanarch.framework"

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(Deps.multidex)
    // Paging
    implementation(Deps.paging)
    addNetworkDependencies()
    addStorageDependencies()
    addFirebaseDependencies()
}