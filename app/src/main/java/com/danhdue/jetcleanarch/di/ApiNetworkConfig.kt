package com.danhdue.jetcleanarch.di

import com.danhdue.jetcleanarch.BuildConfig
import com.danhdue.jetcleanarch.framework.base.app.NetworkConfig

class ApiNetworkConfig  : NetworkConfig() {
    override fun baseUrl(): String {
        return BuildConfig.BASE_URL
    }

    override fun timeOut(): Long {
        return 30L
    }

    override fun isDev(): Boolean {
        return BuildConfig.DEBUG
    }
}