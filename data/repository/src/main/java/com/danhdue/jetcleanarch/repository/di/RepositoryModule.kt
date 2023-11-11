package com.danhdue.jetcleanarch.repository.di

import android.content.Context
import com.danhdue.jetcleanarch.repository.WelcomeRepository
import com.danhdue.jetcleanarch.repository.impl.WelcomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressWarnings("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providesWelcomeRepo(@ApplicationContext context: Context): WelcomeRepository {
        return WelcomeRepositoryImpl(context)
    }
}
