import extensions.addNetworkDependencies
import extensions.addTestDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("com.google.devtools.ksp")
}

android {
    compileSdk = AppConfig.compileSdk
    namespace = "com.danhdue.jetcleanarch.testutils"
}

dependencies {
    addTestDependencies()
    api(Deps.Test.hamcrest)
    api(Deps.Test.hamcrestCore)
    api(Deps.Test.truth)
    api(Deps.Test.turbine)
    api(Deps.Test.mockwebserver)
    api(Deps.Test.json)
    addNetworkDependencies()
}
