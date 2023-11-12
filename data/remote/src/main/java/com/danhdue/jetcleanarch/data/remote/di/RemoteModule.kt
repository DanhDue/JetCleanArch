package com.danhdue.jetcleanarch.data.remote.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.danhdue.jetcleanarch.framework.base.app.NetworkConfig
import com.danhdue.jetcleanarch.framework.network.createChuckInterceptor
import com.danhdue.jetcleanarch.framework.network.createHttpLoggingInterceptor
import com.danhdue.jetcleanarch.framework.network.createHttpRequestInterceptor
import com.danhdue.jetcleanarch.framework.network.createMoshi
import com.danhdue.jetcleanarch.framework.network.createOkHttpClient
import com.danhdue.jetcleanarch.framework.network.interceptor.HttpRequestInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    @Named(value = BASE_URL)
    fun provideBaseUrl(networkConfig: NetworkConfig): String {
        return networkConfig.baseUrl()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return createMoshi()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(networkConfig: NetworkConfig): HttpLoggingInterceptor {
        return createHttpLoggingInterceptor(isDev = networkConfig.isDev())
    }

    @Provides
    @Singleton
    fun provideHttpRequestInterceptor(): HttpRequestInterceptor {
        return createHttpRequestInterceptor()
    }

    @Provides
    @Singleton
    fun provideChuckInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
        return createChuckInterceptor(context)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        httpLoggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
        httpRequestInterceptor: HttpRequestInterceptor
    ): OkHttpClient {
        return createOkHttpClient(
            isCache = true,
            interceptors = arrayOf(
                httpLoggingInterceptor,
                chuckerInterceptor,
                httpRequestInterceptor
            ),
            context = context
        )
    }

    companion object {
        private const val BASE_URL = "base_url"
    }
}
