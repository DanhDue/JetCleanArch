import extensions.TEST
import extensions.addCommonDependencies
import extensions.addComposeDependencies
import extensions.addDebugBuildTypeConfigs
import extensions.addFirebaseDependencies
import extensions.addHiltDependencies
import extensions.addModuleDependencies
import extensions.addNavigationDependencies
import extensions.addNetworkDependencies
import extensions.addReleaseBuildTypeConfigs
import extensions.addStorageDependencies
import extensions.addWorkManagerDependencies
import extensions.buildConfigBooleanField
import extensions.buildConfigStringField
import extensions.implementation
import extensions.setSigningConfigs

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

if (file("google-services.json").exists()) {
    apply(plugin = "com.google.gms.google-services")
    apply(plugin = "com.google.firebase.crashlytics")
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

    compileOptions {
        sourceCompatibility = AppConfig.sourceCompatibility
        targetCompatibility = AppConfig.targetCompatibility
    }

    kotlinOptions {
        languageVersion = AppConfig.kotlinVersion
        apiVersion = AppConfig.kotlinVersion
        jvmTarget = AppConfig.jvmTarget
        freeCompilerArgs = EnvConfigs.FreeCompilerArgs
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

//    dynamicFeatures += setOf(":features:splash")

    setSigningConfigs(project)

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName(EnvConfigs.BuildConfigKey.debugSigningConfigName)
            isDebuggable = true
            applicationIdSuffix = ".dev"
            addDebugBuildTypeConfigs()
            resValue("string", "app_name", "JetCleanArch(Dev)")

            buildConfigStringField(EnvConfigs.BuildConfigKey.BASE_URL, EnvConfigs.Debug.BaseUrl)
            buildConfigStringField(EnvConfigs.BuildConfigKey.DB_NAME, EnvConfigs.Debug.DbName)
            buildConfigBooleanField(EnvConfigs.BuildConfigKey.CRASHLYTIC_IS_ENABLE, EnvConfigs.Debug.crashlyticsEnable)
            buildConfigBooleanField(EnvConfigs.BuildConfigKey.ANALYTIC_IS_ENABLE, EnvConfigs.Debug.analyticsEnable)
        }

        release {
            signingConfig = signingConfigs.getByName(EnvConfigs.BuildConfigKey.releaseSigningConfigName)
            isDebuggable = false
            addReleaseBuildTypeConfigs()
            proguardFiles(
                getDefaultProguardFile(AppConfig.proguardOptimizedFileName),
                AppConfig.proguardConsumerRules
            )
            resValue("string", "app_name", "JetCleanArch(Stg)")

            buildConfigStringField(EnvConfigs.BuildConfigKey.BASE_URL, EnvConfigs.Release.BaseUrl)
            buildConfigStringField(EnvConfigs.BuildConfigKey.DB_NAME, EnvConfigs.Release.DbName)
            buildConfigBooleanField(EnvConfigs.BuildConfigKey.CRASHLYTIC_IS_ENABLE, EnvConfigs.Release.crashlyticsEnable)
            buildConfigBooleanField(EnvConfigs.BuildConfigKey.ANALYTIC_IS_ENABLE, EnvConfigs.Release.analyticsEnable)
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

    addModuleDependencies()

    addStorageDependencies()

    addCommonDependencies()

    addComposeDependencies()

    addNavigationDependencies()

    addHiltDependencies()

    addNetworkDependencies()

    addWorkManagerDependencies()

    addFirebaseDependencies()

    TEST
}
