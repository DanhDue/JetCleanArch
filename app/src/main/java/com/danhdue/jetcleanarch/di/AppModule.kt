package com.danhdue.jetcleanarch.di

import android.content.Context
import com.danhdue.jetcleanarch.JetCleanArchApp
import com.danhdue.jetcleanarch.framework.base.app.AppInitializer
import com.danhdue.jetcleanarch.framework.base.app.AppInitializerImpl
import com.danhdue.jetcleanarch.framework.base.app.MultiDexInitializer
import com.danhdue.jetcleanarch.framework.base.app.NetworkConfig
import com.danhdue.jetcleanarch.framework.base.app.TimberInitializer
import com.danhdue.jetcleanarch.framework.pref.CacheManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesApplication(): JetCleanArchApp {
        return JetCleanArchApp()
    }

    @Provides
    @Singleton
    fun providesNetworkConfig(): NetworkConfig {
        return ApiNetworkConfig()
    }

    @Provides
    @Singleton
    fun providesCacheManager(@ApplicationContext context: Context): CacheManager {
        return CacheManager(context)
    }

    @Provides
    @Singleton
    fun provideTimberInitializer(
        networkConfig: NetworkConfig
    ) = TimberInitializer(networkConfig.isDev())

    @Provides
    @Singleton
    fun provideMultiDexInitializer(
    ) = MultiDexInitializer()

    @Provides
    @Singleton
    fun provideAppInitializer(
        multiDexInitializer: MultiDexInitializer,
        timberInitializer: TimberInitializer
    ): AppInitializer {
        return AppInitializerImpl(
            timberInitializer,
            multiDexInitializer
        )
    }
}
