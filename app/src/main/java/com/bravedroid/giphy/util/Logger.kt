package com.bravedroid.giphy.util

import android.content.Context
import com.bravedroid.giphy.testing.OpenForTesting
import com.facebook.stetho.Stetho
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@OpenForTesting
@Singleton
class Logger @Inject constructor() {

    init {
        log("${this.javaClass.simpleName} ${this.hashCode()}")
    }

    fun configure(context: Context) {
        Timber.plant(Timber.DebugTree())
        Stetho.initializeWithDefaults(context)
    }

    fun log(message: String, tag: String = "logger") = Timber.tag(tag).d(message)
}
