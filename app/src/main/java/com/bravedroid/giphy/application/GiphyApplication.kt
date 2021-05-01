package com.bravedroid.giphy.application

import android.app.Application
import com.bravedroid.giphy.util.Logger
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltAndroidApp
class GiphyApplication : Application() {
    val appCoroutineContext: CoroutineContext by lazy {
        SupervisorJob() + Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            logger.log(" Error in app coroutine context ${throwable.message}")
        }
    }

    @Inject
    lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        logger.configure(this)
    }
}
