package com.bravedroid.giphy.di.factories

import android.content.Context
import com.bravedroid.giphy.di.factories.OkHttpFactory.Companion.OK_HTTP_CACHE_SIZE
import com.bravedroid.giphy.di.factories.OkHttpFactory.Companion.OK_HTTP_CONNECT_TIMEOUT
import com.bravedroid.giphy.di.factories.OkHttpFactory.Companion.OK_HTTP_READ_TIMEOUT
import com.bravedroid.giphy.di.factories.OkHttpFactory.Companion.OK_HTTP_WRITE_TIMEOUT
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class OkHttpFactoryImpl @Inject constructor() : OkHttpFactory {

    override fun create(appContext: Context): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(OK_HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(OK_HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OK_HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .cache(Cache(appContext.cacheDir, OK_HTTP_CACHE_SIZE))
            .build()

}
