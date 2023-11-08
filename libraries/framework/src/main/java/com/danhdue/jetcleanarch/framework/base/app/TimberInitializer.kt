package com.danhdue.jetcleanarch.framework.base.app

import com.danhdue.jetcleanarch.framework.BuildConfig
import com.danhdue.jetcleanarch.framework.utils.CrashReportingTree
import timber.log.Timber

class TimberInitializer(private val isDev: Boolean) : AppInitializer {
    override fun init(coreApp: CoreApplication) {
        if (isDev) {
            Timber.plant(Timber.DebugTree())
        } else {
            if (BuildConfig.CRASHLYTIC_IS_ENABLE) {
                Timber.plant(FirebaseCrashlyticsReportTree())
            } else {
                Timber.plant(CrashReportingTree())
            }
        }
    }
}
