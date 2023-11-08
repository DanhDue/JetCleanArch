package commons

import AppConfig
import Configs
import com.android.build.api.dsl.BuildType
import com.android.build.gradle.LibraryExtension
import extensions.buildConfigBooleanField
import extensions.buildConfigStringField
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidCoreLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.applyPlugins()
        target.configureAndroid()
        target.configureKotlin()
    }

    private fun Project.applyPlugins() {
        plugins.apply("com.android.library")
        plugins.apply("org.jetbrains.kotlin.android")
        plugins.apply("org.jetbrains.kotlin.plugin.parcelize")
        plugins.apply("com.google.devtools.ksp")
    }

    private fun Project.configureKotlin() =
        extensions.getByType(KotlinAndroidProjectExtension::class).run {
            sourceSets.apply {
                getByName("main").kotlin.srcDir("build/generated/ksp/main/kotlin")
                getByName("test").kotlin.srcDir("build/generated/ksp/test/kotlin")
                getByName("debug").kotlin.srcDir("build/generated/ksp/debug/kotlin")
                getByName("release").kotlin.srcDir("build/generated/ksp/release/kotlin")
            }
        }

    private fun Project.configureAndroid() = extensions.getByType(LibraryExtension::class).run {
        compileSdk = AppConfig.compileSdk
        defaultConfig.apply {
            minSdk = AppConfig.minSdk
            targetSdk = AppConfig.targetSdk
            testInstrumentationRunner = Configs.AndroidJunitRunner
        }

        compileOptions.apply {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        project.tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = AppConfig.jvmTarget
                freeCompilerArgs = Configs.FreeCoroutineCompilerArgs
            }
        }

        buildTypes.apply {
            getByName("release") {
                proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
                buildConfigStringField(Configs.BuildConfigKey.BASE_URL, Configs.Release.BaseUrl)
                buildConfigStringField(Configs.BuildConfigKey.DB_NAME, Configs.Release.DbName)
                buildConfigBooleanField(Configs.BuildConfigKey.CRASHLYTIC_IS_ENABLE, Configs.Release.crashlyticsEnable)
                buildConfigBooleanField(Configs.BuildConfigKey.ANALYTIC_IS_ENABLE, Configs.Release.analyticsEnable)
            }
            getByName("debug") {
                proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
                buildConfigStringField(Configs.BuildConfigKey.BASE_URL, Configs.Debug.BaseUrl)
                buildConfigStringField(Configs.BuildConfigKey.DB_NAME, Configs.Debug.DbName)
                buildConfigBooleanField(Configs.BuildConfigKey.CRASHLYTIC_IS_ENABLE, Configs.Debug.crashlyticsEnable)
                buildConfigBooleanField(Configs.BuildConfigKey.ANALYTIC_IS_ENABLE, Configs.Debug.analyticsEnable)
            }
        }
    }
}
