package com.bravedroid.giphy.util

import android.content.Context
import android.util.Log
import com.bravedroid.giphy.BuildConfig
import com.bravedroid.giphy.testing.OpenForTesting
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@OpenForTesting
@Singleton
class Logger @Inject constructor() : AbstractLogger() {
    override fun configure(context: Context) {
//sometimes we want to force debuggable flag in gradle to the release build type
        val isBuildReleaseDebuggable = BuildConfig.DEBUG
        if (isBuildReleaseDebuggable) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    private class ReleaseTree : Timber.Tree() {
        override fun log(
            priority: Int,
            tag: String?,
            message: String,
            t: Throwable?,
        ) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
        }
    }
}
