package com.danhdue.jetcleanarch.di

import android.content.Context
import com.danhdue.jetcleanarch.framework.pref.CacheManager
import com.danhdue.jetcleanarch.provider.AppLanguageProvider
import com.danhdue.jetcleanarch.provider.AppResourceProvider
import com.danhdue.jetcleanarch.provider.AppThemeProvider
import com.danhdue.jetcleanarch.providers.LanguageProvider
import com.danhdue.jetcleanarch.providers.ResourceProvider
import com.danhdue.jetcleanarch.providers.ThemeProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProviderModule {

    @Provides
    @Singleton
    fun provideThemProvider(@ApplicationContext context: Context): ThemeProvider {
        return AppThemeProvider(context)
    }

    @Provides
    @Singleton
    fun provideLanguageProvider(cacheManager: CacheManager): LanguageProvider {
        return AppLanguageProvider(cacheManager)
    }

    @Provides
    @Singleton
    fun providesResourceProvider(@ApplicationContext context: Context): ResourceProvider {
        return AppResourceProvider(context)
    }
}
