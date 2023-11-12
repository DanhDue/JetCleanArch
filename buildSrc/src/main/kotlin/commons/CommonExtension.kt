package commons


import com.google.devtools.ksp.processing.Resolver
import AppConfig
import java.io.File
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * load a property from local property files.
 */
fun getLocalProperty(key: String, file: String = "local.properties"): Any {
    val properties = java.util.Properties()
    val localProperties = File(file)
    if (localProperties.isFile) {
        java.io.InputStreamReader(java.io.FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    } else error("File from not found")

    return properties.getProperty(key)
}

/**
 * Adds the base Compose configurations on Gradle.
 */
fun CommonExtension<*, *, *, *, *>.addComposeConfig() {

    compileOptions {
        sourceCompatibility = AppConfig.sourceCompatibility
        targetCompatibility = AppConfig.targetCompatibility
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }

    packaging {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
            jniLibs.pickFirsts.add("**/*.so")
        }
    }
}

/**
 * Adds the base default app configurations on Gradle.
 */
fun CommonExtension<*, *, *, *, *>.addDefaultConfig() {
    defaultConfig {
        compileSdk = AppConfig.compileSdk
        minSdk = AppConfig.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = AppConfig.sourceCompatibility
        targetCompatibility = AppConfig.targetCompatibility
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}
