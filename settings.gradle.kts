pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

buildCache {
    local {
        // Set local build cache directory.
        directory = "${settingsDir}/build-caches"
    }
}

rootProject.name = "JetCleanArch"
include(":app")
include(":libraries:framework")
include(":libraries:jetframework")
include(":libraries:testutils")
include(":data:model")
include(":data:local")
include(":data:remote")
include(":data:repository")
include(":common:theme")
include(":common:components")
include(":common:providers")
include(":domain")
include(":features:splash")
