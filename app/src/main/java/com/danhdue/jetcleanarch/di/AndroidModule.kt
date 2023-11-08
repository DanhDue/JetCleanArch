package com.danhdue.jetcleanarch.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ExecutorNetworkIO

@Module
@InstallIn(SingletonComponent::class)
class AndroidModule {

    @Provides
    @Singleton
    fun providesContext(@ApplicationContext context: Context): Context {
        return context
    }

    @ExecutorNetworkIO
    @Singleton
    @Provides
    fun providesExecutorNetworkIO(): Executor = Executors.newFixedThreadPool(2)

}
