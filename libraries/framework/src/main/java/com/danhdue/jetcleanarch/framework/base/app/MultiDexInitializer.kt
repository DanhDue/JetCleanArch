package com.danhdue.jetcleanarch.framework.base.app

import androidx.multidex.MultiDex

class MultiDexInitializer: AppInitializer {
    override fun init(coreApp: CoreApplication) {
        MultiDex.install(coreApp)
    }
}
