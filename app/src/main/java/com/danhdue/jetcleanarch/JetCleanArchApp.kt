package com.danhdue.jetcleanarch

import android.util.Log
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDexApplication
import com.danhdue.jetcleanarch.framework.utils.CrashReportingTree
import com.danhdue.jetcleanarch.framework.utils.FakeCrashLibrary
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant

@HiltAndroidApp
class JetCleanArchApp: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        } else {
            plant(CrashReportingTree())
        }
    }
}
