package com.observer.playzone

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        PlatformSdk.init()
    }
}


