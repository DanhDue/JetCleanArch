package com.danhdue.jetcleanarch.providers

import android.content.Context

interface LanguageProvider {
    fun saveLanguageCode(languageCode: String)
    fun getLanguageCode(): String
    fun setLocale(language: String, context: Context)
}
