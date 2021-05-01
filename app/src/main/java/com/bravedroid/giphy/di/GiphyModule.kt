package com.bravedroid.giphy.di

import android.content.Context
import com.bravedroid.giphy.di.factories.OkHttpFactory
import com.bravedroid.giphy.di.factories.OkHttpFactoryImpl
import com.bravedroid.giphy.infrastructure.network.services.GiphyService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(ApplicationComponent::class)
class GiphyModule {

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

   @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext appContext: Context, okHttpFactory: OkHttpFactory): OkHttpClient =
        okHttpFactory.create(appContext)

    @Singleton
    @Provides
    fun provideRetrofitConverterFactory() =
        Json.asConverterFactory("application/json".toMediaType())

    private companion object {
        private const val BASE_URL = "https://api.giphy.com/v1/gifs/"
    }
}
