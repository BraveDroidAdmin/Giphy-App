package com.bravedroid.giphy.util

import android.content.Context
import com.bravedroid.giphy.testing.OpenForTesting
import com.facebook.stetho.Stetho
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@OpenForTesting
@Singleton
class Logger @Inject constructor() : AbstractLogger() {
    override fun configure(context: Context) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(context)
    }
}
