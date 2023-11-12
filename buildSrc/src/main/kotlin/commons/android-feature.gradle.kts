package commons

import AppConfig
import EnvConfigs
import extensions.TEST
import extensions.addCommonDependencies
import extensions.addNavigationDependencies
import extensions.buildConfigBooleanField
import extensions.buildConfigStringField

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("com.google.devtools.ksp")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            buildConfigStringField(EnvConfigs.BuildConfigKey.BASE_URL, EnvConfigs.Release.BaseUrl)
            buildConfigStringField(EnvConfigs.BuildConfigKey.DB_NAME, EnvConfigs.Release.DbName)
            buildConfigBooleanField(EnvConfigs.BuildConfigKey.CRASHLYTIC_IS_ENABLE, EnvConfigs.Release.crashlyticsEnable)
            buildConfigBooleanField(EnvConfigs.BuildConfigKey.ANALYTIC_IS_ENABLE, EnvConfigs.Release.analyticsEnable)
        }

        debug {
            buildConfigStringField(EnvConfigs.BuildConfigKey.BASE_URL, EnvConfigs.Debug.BaseUrl)
            buildConfigStringField(EnvConfigs.BuildConfigKey.DB_NAME, EnvConfigs.Debug.DbName)
            buildConfigBooleanField(EnvConfigs.BuildConfigKey.CRASHLYTIC_IS_ENABLE, EnvConfigs.Debug.crashlyticsEnable)
            buildConfigBooleanField(EnvConfigs.BuildConfigKey.ANALYTIC_IS_ENABLE, EnvConfigs.Debug.analyticsEnable)
        }
    }

    compileOptions {
        sourceCompatibility = AppConfig.sourceCompatibility
        targetCompatibility = AppConfig.targetCompatibility
    }

    buildFeatures {
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
        freeCompilerArgs = EnvConfigs.FreeCompilerArgs
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

android.libraryVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName("main") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
        getByName("test") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
        getByName("debug") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
        getByName("release") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

dependencies {
    // Common
    addCommonDependencies()

    // compose navigation
    addNavigationDependencies()
    // Test
    TEST
}
