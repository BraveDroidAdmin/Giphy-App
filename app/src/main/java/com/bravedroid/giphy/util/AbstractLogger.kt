package com.bravedroid.giphy.util

import android.content.Context
import com.bravedroid.giphy.testing.OpenForTesting
import timber.log.Timber
import javax.inject.Singleton

@OpenForTesting
@Singleton
abstract class AbstractLogger {

    init {
        log("${this.javaClass.simpleName} ${this.hashCode()}")
    }

    abstract fun configure(context: Context)

    fun log(message: String, tag: String = "logger") = Timber.tag(tag).d(message)
    fun logError(errorMessage: String, tag: String = "logger") = Timber.tag(tag).e(errorMessage)
}
