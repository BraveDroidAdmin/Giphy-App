package com.bravedroid.giphy.di.factories

import android.content.Context
import okhttp3.OkHttpClient

interface OkHttpFactory {
    companion object {
        const val OK_HTTP_CACHE_SIZE = 150L * 1024 * 1024 // 150MB
        const val OK_HTTP_CONNECT_TIMEOUT = 60L
        const val OK_HTTP_WRITE_TIMEOUT = 60L
        const val OK_HTTP_READ_TIMEOUT = 60L
    }

    fun create(appContext: Context): OkHttpClient
}
