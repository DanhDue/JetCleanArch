package com.danhdue.jetcleanarch.domain.di

import android.annotation.SuppressLint
import com.danhdue.jetcleanarch.domain.usecase.welcome.ReadOnBoarding
import com.danhdue.jetcleanarch.domain.usecase.welcome.SaveOnBoarding
import com.danhdue.jetcleanarch.repository.WelcomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class WelcomeModule {

    @Provides
    @Singleton
    fun provideSaveOnBoarding(repository: WelcomeRepository): SaveOnBoarding {
        return SaveOnBoarding(repository)
    }

    @Provides
    @Singleton
    fun provideReadOnBoarding(repository: WelcomeRepository): ReadOnBoarding {
        return ReadOnBoarding(repository)
    }
}
