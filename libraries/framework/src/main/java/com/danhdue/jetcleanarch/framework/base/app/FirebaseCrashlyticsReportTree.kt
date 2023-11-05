package com.danhdue.jetcleanarch.framework.base.app

import android.util.Log
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import timber.log.Timber

class FirebaseCrashlyticsReportTree : Timber.Tree() {

    init {
        Firebase.crashlytics.setCrashlyticsCollectionEnabled(true)
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR) {
            Firebase.crashlytics.log(message)
            Firebase.crashlytics.setCustomKey(tag.toString(), message)
            t?.let {
                Firebase.crashlytics.recordException(it)
                with(Firebase.crashlytics) {
                    // optional: setCustomKey("CUSTOME_TAG", any)
                    recordException(it)
                }
            }
        }
    }
}
