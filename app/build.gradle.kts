import extensions.addCommonDependencies
import extensions.addComposeDependencies
import extensions.addHiltDependencies
import extensions.addNetworkDependencies
import extensions.addStorageDependencies
import extensions.addTestDependencies
import extensions.addWorkManagerDependencies
import extensions.implementation

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSdk
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
        multiDexEnabled = true

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(AppConfig.proguardOptimizedFileName),
                AppConfig.proguardConsumerRules
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/DEPENDENCIES"
            excludes += "META-INF/LICENSE"
            excludes += "META-INF/LICENSE.txt"
            excludes += "META-INF/license.txt"
            excludes += "META-INF/LICENSE.md"
            excludes += "META-INF/LICENSE-notice.md"
            excludes += "META-INF/NOTICE"
            excludes += "META-INF/NOTICE.txt"
            excludes += "META-INF/notice.txt"
            excludes += "META-INF/ASL2.0"
            excludes += "META-INF/*.kotlin_module"
            excludes += "META-INF/gradle/incremental.annotation.processors"
            excludes += "/META-INF/{AL2.0,LGPL2.1,gradle-plugins}"
            jniLibs.pickFirsts.add("**/*.so")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }

    bundle {
        density.enableSplit = true
        abi.enableSplit = true
        language.enableSplit = false
    }

    lint {
        checkReleaseBuilds = false
        abortOnError = false
        disable.add("MissingTranslation")
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            applicationIdSuffix = ".debug"
            enableUnitTestCoverage = false
            enableAndroidTestCoverage = false
            resValue("string", "app_name", "ViVi(Sta)")
            buildConfigField(
                "String",
                "API_BASE_URL",
                "\"https://dev-cloud.vinbase.ai\""
            )
            buildConfigField(
                "String",
                "LOGIN_API_BASE_URL",
                "\"https://dev-iam.vinbase.ai\""
            )
            buildConfigField(
                "String",
                "WSS_BASE_URL",
                "\"wss://dev-cloud.vinbase.ai\""
            )
        }

        getByName("release") {
            isMinifyEnabled = false
            enableUnitTestCoverage = false
            enableAndroidTestCoverage = false
            resValue("string", "app_name", "ViVi(Sta)")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "API_BASE_URL",
                "\"https://dev-cloud.vinbase.ai\""
            )
            buildConfigField(
                "String",
                "LOGIN_API_BASE_URL",
                "\"https://dev-iam.vinbase.ai\""
            )
            buildConfigField(
                "String",
                "WSS_BASE_URL",
                "\"wss://dev-cloud.vinbase.ai\""
            )
        }
    }
}

android.applicationVariants.all {
    val variantName = name
    kotlin.sourceSets {
        getByName("main") {
            kotlin.srcDir(File("build/generated/ksp/$variantName/kotlin"))
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Deps.multidex)

    addStorageDependencies()

    addCommonDependencies()

    addComposeDependencies()

    implementation(Deps.timber)

    addHiltDependencies()

    addNetworkDependencies()

    addWorkManagerDependencies()

    addTestDependencies()
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
