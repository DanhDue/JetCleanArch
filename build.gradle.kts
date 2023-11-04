buildscript {
    dependencies { classpath(Deps.ANDROID_GRADLE_PLUGIN) }
}

plugins {
    id(Deps.GOOGLE_SERVICE_GRADLE_PLUGIN_ID) version Versions.GOOGLE_SERVICE apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
