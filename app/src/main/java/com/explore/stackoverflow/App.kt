package com.explore.stackoverflow

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by Annas Surdyanto on 06/09/21.
 *
 */
@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        appContext = this.applicationContext
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        var appContext: Context? = null
    }
}