import commons.addDefaultConfig
import extensions.addNetworkDependencies
import extensions.addTestDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.danhdue.jetcleanarch.testutils"

    addDefaultConfig()

    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
        freeCompilerArgs = EnvConfigs.FreeCoroutineCompilerArgs
    }
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
