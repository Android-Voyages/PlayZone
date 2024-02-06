package com.observer.playzone.android

import PlatformConfiguration
import PlatformSdk
import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initPlatformSdk()
    }


    fun initPlatformSdk() =
        PlatformSdk.init(
            configuration = PlatformConfiguration(androidContext = applicationContext)
        )
}


