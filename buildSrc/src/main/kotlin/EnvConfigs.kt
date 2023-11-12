object EnvConfigs {
    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0
    private const val versionQualifier = "alpha1"

    private fun generateVersionCode(): Int {
        return versionMajor * 10000 + versionMinor * 100 + versionPatch
    }

    private fun generateVersionName(): String {
        return "$versionMajor.$versionMinor.$versionPatch"
    }

    val VersionCode = generateVersionCode()
    val VersionName = generateVersionName()
    const val AndroidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"

    val FreeCompilerArgs = listOf(
        "-Xjvm-default=all",
        "-opt-in=kotlin.RequiresOptIn",
        "-opt-in=kotlin.Experimental",
        "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-opt-in=kotlinx.coroutines.InternalCoroutinesApi",
        "-opt-in=kotlinx.coroutines.FlowPreview",
        "-opt-in=androidx.compose.material.ExperimentalMaterialApi",
        "-opt-in=com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi",
        "-opt-in=androidx.compose.animation.ExperimentalAnimationApi"
    )

    val FreeCoroutineCompilerArgs = listOf(
        "-Xjvm-default=all",
        "-opt-in=kotlin.RequiresOptIn",
        "-opt-in=kotlin.Experimental",
        "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-opt-in=kotlinx.coroutines.InternalCoroutinesApi",
        "-opt-in=kotlinx.coroutines.FlowPreview"
    )

    object BuildConfigKey {
        const val bitbucketUserNameKey = "bitbucket.userName"

        const val debugBuildTypeName = "debug"
        const val debugSigningConfigName = "debug"
        const val releaseBuildTypeName = "release"
        const val releaseSigningConfigName = "signingConfigRelease"

        const val crashlyticsEnableKey = "crashlyticsEnabled"
        const val analyticsEnableKey = "analyticsEnabled"

        const val BASE_URL = "BASE_URL"
        const val DB_NAME = "DB_NAME"
        const val CRASHLYTIC_IS_ENABLE = "CRASHLYTIC_IS_ENABLE"
        const val ANALYTIC_IS_ENABLE = "ANALYTIC_IS_ENABLE"
    }

    object Release {
        const val BaseUrl = "https://danhdue.com/api/"
        const val DbName = "JetCleanArchDb"

        const val crashlyticsEnable = true
        const val analyticsEnable = true
    }

    object Debug {
        const val BaseUrl = "https://danhdue.com/api/"
        const val DbName = "JetCleanArchDb"

        const val crashlyticsEnable = false
        const val analyticsEnable = false
    }
}
