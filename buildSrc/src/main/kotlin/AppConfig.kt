import org.gradle.api.JavaVersion

object AppConfig {
    const val namespace = "com.danhdue.jetcleanarch"
    const val compileSdk = 34
    const val buildToolsVersion = "34.0.0"
    const val applicationId = "com.danhdue.jetcleanarch"
    const val minSdk = 28
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardOptimizedFileName = "proguard-android-optimize.txt"
    const val proguardConsumerRules = "proguard-rules.pro"
    const val jvmTarget = "17"
    const val kotlinCompilerExtensionVersion = "1.5.4"

    val sourceCompatibility = JavaVersion.VERSION_17
    val targetCompatibility = JavaVersion.VERSION_17
}
