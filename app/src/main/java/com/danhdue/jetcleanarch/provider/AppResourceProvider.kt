package com.danhdue.jetcleanarch.provider

import android.content.Context
import com.danhdue.jetcleanarch.providers.ResourceProvider

class AppResourceProvider(private val context: Context) : ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}
