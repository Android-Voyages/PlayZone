package com.observer.playzone

import android.app.Application
import com.observer.playzone.di.PlatformSdk

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        PlatformSdk.init()
    }
}


