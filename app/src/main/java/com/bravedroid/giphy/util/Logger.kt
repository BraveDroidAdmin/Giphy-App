package com.bravedroid.giphy.util

import com.bravedroid.giphy.testing.OpenForTesting
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@OpenForTesting
@Singleton
class Logger @Inject constructor() {

    init {
        log("${this.javaClass.simpleName} ${this.hashCode()}")
    }

    fun configure() = Timber.plant(Timber.DebugTree())

    fun log(message: String, tag: String = "logger") = Timber.tag(tag).d(message)
}
