package com.escmobile.showmethecat

import android.app.Application
import com.escmobile.showmethecat.di.apiModule
import com.escmobile.showmethecat.di.dataModule
import org.koin.android.BuildConfig
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber
import timber.log.Timber.Forest.plant


class CatApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()

        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        }
    }

    private fun initKoin() {
        startKoin {
            applicationContext
            modules(
                listOf(
                    dataModule,
                    apiModule
                )
            )
        }

    }
}