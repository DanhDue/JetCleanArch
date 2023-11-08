package extensions

import Configs
import Deps
import com.android.build.api.dsl.BuildType
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.add

//import com.android.build.gradle.internal.dsl.BuildType

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

fun BuildType.addDebugBuildTypeConfigs() {
    enableUnitTestCoverage = false
    enableAndroidTestCoverage = false
    manifestPlaceholders[Configs.BuildConfigKey.crashlyticsEnableKey] = false
    manifestPlaceholders[Configs.BuildConfigKey.analyticsEnableKey] = false
}

fun BuildType.addReleaseBuildTypeConfigs() {
    isMinifyEnabled = true
    isShrinkResources = true
    enableUnitTestCoverage = false
    enableAndroidTestCoverage = false
    manifestPlaceholders[Configs.BuildConfigKey.crashlyticsEnableKey] = true
    manifestPlaceholders[Configs.BuildConfigKey.analyticsEnableKey] = true
}

fun DependencyHandler.addCommonDependencies() {
    implementation(Deps.timber)
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.Kotlin.coroutineCore)
    implementation(Deps.Kotlin.coroutine)
    implementation(Deps.lifecycleRuntimeKtx)
    implementation(Deps.activityKtx)
}

fun DependencyHandler.addNetworkDependencies() {
    addJsonParsingDependencies()
    // Retrofit
    implementation(Deps.Networking.retrofit)
    implementation(Deps.Networking.retrofitMoshiConverter)
    // okhttp
    addOkhttpDependencies()
    // chucker
    debugImplementation(Deps.Networking.chuckerDebug)
    releaseImplementation(Deps.Networking.chuckerRelease)
}

fun DependencyHandler.addJsonParsingDependencies() {
    implementation(Deps.Moshi.core)
    ksp(Deps.Moshi.codeGen)
    implementation(Deps.Moshi.lazyAdapter)
}

fun DependencyHandler.addOkhttpDependencies() {
    implementation(platform(Deps.Okhttp.bom))
    implementation(Deps.Okhttp.core)
    implementation(Deps.Okhttp.loggingInterceptor)
    testImplementation(Deps.Okhttp.mockwebserver)
}

fun DependencyHandler.addTestDependencies() {
    api(Deps.Test.junit)
    api(Deps.Test.junitExt)
    api(Deps.espressoCore)
    api(Deps.Kotlin.coroutineTest)
    api(Deps.Test.robolectric)
    api(Deps.Test.mockk)
}

fun DependencyHandler.addStorageDependencies() {
    addRoomDependencies()
    implementation(Deps.Storage.dataStorePref)
    implementation(Deps.Storage.dataStore)
    implementation(Deps.Storage.securePref)
}

fun DependencyHandler.addRoomDependencies() {
    implementation(Deps.Storage.roomKtx)
    ksp(Deps.Storage.roomCompiler)
}

fun DependencyHandler.addHiltDependencies() {
    implementation(Deps.Hilt.core)
    ksp(Deps.Hilt.compiler)
    androidTestImplementation(Deps.Hilt.testing)
    kspAndroidTest(Deps.Hilt.compiler)
    testImplementation(Deps.Hilt.testing)
    kspTest(Deps.Hilt.compiler)
}

fun DependencyHandler.addComposeDependencies() {
    implementation(platform(Deps.Compose.composeBOM))
    implementation(Deps.Compose.composeUI)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.uiToolingPreview)
    implementation(Deps.Compose.runtime)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.iconsCore)
    implementation(Deps.Compose.iconsExtended)

    implementation(Deps.Compose.activityCompose)
    implementation(Deps.Compose.lifecycleViewmodelCompose)
    implementation(Deps.Compose.constraintLayout)
    implementation(Deps.Compose.lottieCompose)
    implementation(Deps.Compose.pagingCompose)
    implementation(Deps.Compose.coil)
    implementation(Deps.Compose.composeUIGraphics)
    implementation(Deps.Compose.material3)

    // Accompanist
    implementation(Deps.Accompanist.swiperefresh)
    implementation(Deps.Accompanist.systemuicontroller)
    implementation(Deps.Accompanist.insets)
    implementation(Deps.Accompanist.materialPlaceHolder)
    implementation(Deps.Accompanist.navigation)
    implementation(Deps.Accompanist.permissions)
    implementation(Deps.Accompanist.pager)
    implementation(Deps.Accompanist.pagerIndicators)
    implementation(Deps.Accompanist.webview)

    // Compose Testing
    androidTestImplementation(platform(Deps.Compose.composeBOM))
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

fun DependencyHandler.addFirebaseDependencies() {
    implementation(platform(Deps.Firebase.bom))
    implementation(Deps.Firebase.analytics)
    implementation(Deps.Firebase.crashlytics)
    implementation(Deps.Firebase.messaging)
    implementation(Deps.Firebase.remoteConfig)
}

fun DependencyHandler.addModuleDependencies() {
    implementation(project(mapOf("path" to ":domain")))

    implementation(project(mapOf("path" to ":data:model")))
    implementation(project(mapOf("path" to ":data:local")))
    implementation(project(mapOf("path" to ":data:remote")))
    implementation(project(mapOf("path" to ":data:repository")))

    implementation(project(mapOf("path" to ":common:theme")))
    implementation(project(mapOf("path" to ":common:components")))
    implementation(project(mapOf("path" to ":common:providers")))

    implementation(project(mapOf("path" to ":libraries:framework")))
    implementation(project(mapOf("path" to ":libraries:jetframework")))
    implementation(project(mapOf("path" to ":libraries:testutils")))
}

val DependencyHandler.FRAMEWORK
    get() = implementation(project(mapOf("path" to ":libraries:framework")))

val DependencyHandler.JETFRAMEWORK
    get() = implementation(project(mapOf("path" to ":libraries:jetframework")))

val DependencyHandler.TEST
    get() = testImplementation(project(mapOf("path" to ":libraries:testutils")))

val DependencyHandler.MODEL
    get() = implementation(project(mapOf("path" to ":data:model")))

val DependencyHandler.LOCAL
    get() = implementation(project(mapOf("path" to ":data:local")))

val DependencyHandler.REMOTE
    get() = implementation(project(mapOf("path" to ":data:remote")))

val DependencyHandler.REPOSITORY
    get() = implementation(project(mapOf("path" to ":data:repository")))

val DependencyHandler.THEME
    get() = implementation(project(mapOf("path" to ":common:theme")))

val DependencyHandler.COMPONENT
    get() = implementation(project(mapOf("path" to ":common:components")))

val DependencyHandler.PROVIDER
    get() = implementation(project(mapOf("path" to ":common:providers")))

val DependencyHandler.DOMAIN
    get() = implementation(project(mapOf("path" to ":domain")))
