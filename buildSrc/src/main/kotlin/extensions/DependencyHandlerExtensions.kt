package extensions

import Deps
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.add

/**
 * Adds a dependency to the `releaseImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.releaseImplementation(dependencyNotation: Any): Dependency? =
    add("releaseImplementation", dependencyNotation)

/**
 * Adds a dependency to the `debugImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

/**
 * Adds a dependency to the `implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

/**
 * Adds a dependency to the `api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
    add("api", dependencyNotation)

/**
 * Adds a dependency to the `kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)

/**
 * Adds a dependency to the 'kaptTest' configuration.
 *
 * @param dependencyNotation notation for the dependency to be added.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.kaptTest(dependencyNotation: Any): Dependency? =
    add("kaptTest", dependencyNotation)

/**
 * Adds a dependency to the 'kaptAndroidTest' configuration.
 *
 * @param dependencyNotation notation for the dependency to be added.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.kaptAndroidTest(dependencyNotation: Any): Dependency? =
    add("kaptAndroidTest", dependencyNotation)

/**
 * Adds a dependency to the `testImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)


/**
 * Adds a dependency to the `androidTestImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

/**
 * Adds a dependency to the `ksp` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.ksp(dependencyNotation: Any): Dependency? =
    add("ksp", dependencyNotation)

/**
 * Adds a dependency to the 'kspTest' configuration.
 *
 * @param dependencyNotation notation for the dependency to be added.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.kspTest(dependencyNotation: Any): Dependency? =
    add("kspTest", dependencyNotation)

/**
 * Adds a dependency to the 'kspAndroidTest' configuration.
 *
 * @param dependencyNotation notation for the dependency to be added.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.kspAndroidTest(dependencyNotation: Any): Dependency? =
    add("kspAndroidTest", dependencyNotation)

fun DependencyHandler.addCommonDependencies() {
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.Kotlin.coroutineCore)
    implementation(Deps.Kotlin.coroutine)
    implementation(Deps.lifecycleRuntimeKtx)
    implementation(Deps.activityKtx)
}

fun DependencyHandler.addNetworkDependencies() {
    implementation(Deps.Networking.moshi)
    ksp(Deps.Networking.moshiCodeGen)
    implementation(Deps.Networking.moshiLazyAdapter)
    implementation(Deps.Networking.retrofit)
    implementation(Deps.Networking.retrofitMoshiConverter)
    implementation(platform(Deps.Networking.Okhttp.bom))
    implementation(Deps.Networking.Okhttp.core)
    implementation(Deps.Networking.Okhttp.loggingInterceptor)
    testImplementation(Deps.Networking.Okhttp.mockwebserver)
    debugImplementation(Deps.Networking.chuckerDebug)
    releaseImplementation(Deps.Networking.chuckerRelease)
}

fun DependencyHandler.addTestDependencies() {
    testImplementation(Deps.Test.junit)
    androidTestImplementation(Deps.Test.junitExt)
    androidTestImplementation(Deps.espressoCore)
    testImplementation(Deps.Kotlin.coroutineTest)
    testImplementation(Deps.Test.robolectric)
    testImplementation(Deps.Test.mockk)
}

fun DependencyHandler.addStorageDependencies() {
    implementation(Deps.Storage.roomKtx)
    ksp(Deps.Storage.roomCompiler)
    implementation(Deps.Storage.dataStorePref)
    implementation(Deps.Storage.dataStore)
    implementation(Deps.Storage.securePref)
}

fun DependencyHandler.addHiltDependencies() {
    implementation(Deps.Hilt.core)
    kapt(Deps.Hilt.compiler)
    androidTestImplementation(Deps.Hilt.testing)
    kaptAndroidTest(Deps.Hilt.compiler)
    testImplementation(Deps.Hilt.testing)
    kaptTest(Deps.Hilt.compiler)
}

fun DependencyHandler.addComposeDependencies() {
    implementation(Deps.activityCompose)
    implementation(platform(Deps.composeBOM))
    implementation(Deps.composeUI)
    implementation(Deps.composeUIGraphics)
    implementation(Deps.uiToolingPreview)
    implementation(Deps.material3)

    // Compose Testing
    androidTestImplementation(platform(Deps.composeBOM))
    debugImplementation(Deps.Test.uiTooling)
    debugImplementation(Deps.Test.uiTestManifest)
    androidTestImplementation(Deps.Test.uiTestJunit4)
}

fun DependencyHandler.addWorkManagerDependencies() {
    implementation(Deps.WorkManager.workRuntimeKtx)
    implementation(Deps.WorkManager.workMultiProcess)
    androidTestImplementation(Deps.WorkManager.workTesting)
}

fun DependencyHandler.addNavigationDependencies() {
    implementation(Deps.Navigation.navigation)
    implementation(Deps.Navigation.destCore)
    ksp(Deps.Navigation.destCoreKsp)
    implementation(Deps.Navigation.destAnimation)
}
