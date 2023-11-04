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
 