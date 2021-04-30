package com.bravedroid.giphy.di

import android.content.Context
import com.bravedroid.giphy.infrastructure.network.services.GiphyService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(ApplicationComponent::class)
class GiphyModule {

    @Singleton
    @Provides
    fun provideOkHttp(@ApplicationContext appContext: Context): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(OK_HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(OK_HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OK_HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .cache(Cache(appContext.cacheDir, OK_HTTP_CACHE_SIZE))
//            .addNetworkInterceptor(LoggerInterceptor.logWithStetho)
            .build()

    @Singleton
    @Provides
    fun provideRetrofitConverterFactory() =
        Json.asConverterFactory("application/json".toMediaType())

    @Singleton
    @Provides
    fun provideGiphyService(
        okHttpClient: OkHttpClient,
        factory: Converter.Factory,
    ): GiphyService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(factory)
        .build()
        .create(GiphyService::class.java)

    private companion object {
        private const val BASE_URL = "https://api.giphy.com/v1/gifs/"
        private const val OK_HTTP_CACHE_SIZE = 150L * 1024 * 1024 // 150MB
        private const val OK_HTTP_CONNECT_TIMEOUT = 60L
        private const val OK_HTTP_WRITE_TIMEOUT = 60L
        private const val OK_HTTP_READ_TIMEOUT = 60L
    }
}
