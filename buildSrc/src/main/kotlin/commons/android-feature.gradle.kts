package commons

import AppConfig
import Configs
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
            buildConfigStringField(Configs.BuildConfigKey.BASE_URL, Configs.Release.BaseUrl)
            buildConfigStringField(Configs.BuildConfigKey.DB_NAME, Configs.Release.DbName)
            buildConfigBooleanField(Configs.BuildConfigKey.CRASHLYTIC_IS_ENABLE, Configs.Release.crashlyticsEnable)
            buildConfigBooleanField(Configs.BuildConfigKey.ANALYTIC_IS_ENABLE, Configs.Release.analyticsEnable)
        }

        debug {
            buildConfigStringField(Configs.BuildConfigKey.BASE_URL, Configs.Debug.BaseUrl)
            buildConfigStringField(Configs.BuildConfigKey.DB_NAME, Configs.Debug.DbName)
            buildConfigBooleanField(Configs.BuildConfigKey.CRASHLYTIC_IS_ENABLE, Configs.Debug.crashlyticsEnable)
            buildConfigBooleanField(Configs.BuildConfigKey.ANALYTIC_IS_ENABLE, Configs.Debug.analyticsEnable)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
        freeCompilerArgs = Configs.FreeCompilerArgs
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
