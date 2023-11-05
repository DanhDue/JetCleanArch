object Deps {

    const val ANDROID_GRADLE_PLUGIN_ID = "com.android.application"
    const val ANDROID_LIBRARY_GRADLE_PLUGIN_ID = "com.android.library"
    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:${Versions.GRADLE}"
    const val KOTLIN_GRADLE_PLUGIN_ID = "org.jetbrains.kotlin.android"
    const val HILT_GRADLE_PLUGIN_ID = "com.google.dagger.hilt.android"
    const val KSP_GRADLE_PLUGIN_ID = "com.google.devtools.ksp"
    const val GOOGLE_SERVICE_GRADLE_PLUGIN_ID = "com.google.gms.google-services"

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeUI =  "androidx.compose.ui:ui"
    const val composeUIGraphics = "androidx.compose.ui:ui-graphics"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:material3:${Versions.material3}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val composeBOM = "androidx.compose:compose-bom:${Versions.composeBOM}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    const val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreen}"
    const val paging = "androidx.paging:paging-runtime-ktx:${Versions.paging}"

    object Hilt {
        const val core = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
        const val testing = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
    }

    object Navigation {
        const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
        const val destCore = "io.github.raamcosta.compose-destinations:core:${Versions.navigation}"
        const val destCoreKsp = "io.github.raamcosta.compose-destinations:ksp:${Versions.navigation}"
        const val destAnimation = "io.github.raamcosta.compose-destinations:animations-core:${Versions.navigation}"
    }

    object WorkManager {
        const val workRuntimeKtx = "androidx.work:work-runtime-ktx:${Versions.workManager}"
        const val workMultiProcess = "androidx.work:work-multiprocess:${Versions.workManager}"
        const val workGCM = "androidx.work:work-gcm:${Versions.workManager}"
        const val workTesting = "androidx.work:work-testing:${Versions.workManager}"
    }

    object Networking {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

        const val chuckerDebug = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
        const val chuckerRelease = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"
    }

    object Okhttp {
        const val bom = "com.squareup.okhttp3:okhttp-bom:${Versions.okhttp}"
        const val core = "com.squareup.okhttp3:okhttp"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
        const val mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    }

    object Moshi {
        const val core = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
        const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
        const val lazyAdapter = "com.serjltt.moshi:moshi-lazy-adapters:${Versions.moshiLazyAdapter}"
    }

    object Storage {
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val dataStore = "androidx.datastore:datastore:${Versions.dataStore}"
        const val dataStorePref = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
        const val securePref = "androidx.security:security-crypto-ktx:${Versions.securePref}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutine}"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutine}"
        const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutine}"
    }

    object Firebase {
        const val bom = "com.google.firebase:firebase-bom:${Versions.firebase}"
        const val analytics = "com.google.firebase:firebase-analytics"
        const val crashlytics = "com.google.firebase:firebase-crashlytics"
        const val messaging = "com.google.firebase:firebase-messaging"
        const val inAppMessaging = "com.google.firebase:firebase-inappmessaging"
        const val inAppMessagingDisplay = "com.google.firebase:firebase-inappmessaging-display"
        const val remoteConfig = "com.google.firebase:firebase-config"
    }

    object Test {
        const val junit =  "junit:junit:${Versions.junit}"
        const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
        const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
        const val uiTooling = "androidx.compose.ui:ui-tooling"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
        const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
        const val mockito = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
        const val hamcrest = "org.hamcrest:hamcrest-library:${Versions.hamcrest}"
        const val hamcrestCore = "org.hamcrest:hamcrest-core:${Versions.hamcrest}"
        const val mockk = "io.mockk:mockk:${Versions.mockk}"
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    }
}

object Modules {
    const val buildSrc = ":buildSrc"
}
