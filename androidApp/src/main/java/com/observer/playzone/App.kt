package com.observer.playzone

import PlatformConfiguration
import PlatformSDK
import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun App.initPlatformSDK() =
    PlatformSDK.init(
        configuration = PlatformConfiguration(androidContext = applicationContext)
    )