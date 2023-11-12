package com.danhdue.jetcleanarch.data.local.di

import com.danhdue.jetcleanarch.model.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    @Singleton
    @Named(value = DB_NAME)
    fun provideDatabaseName(): String {
        return BuildConfig.DB_NAME
    }

    companion object {
        private const val DB_NAME = "db_name"
    }
}
