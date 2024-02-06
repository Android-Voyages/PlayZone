package com.observer.playzone.di

import coreModule
import org.kodein.di.DI
import org.kodein.di.direct
import umbrellaModule
import gamesModule
object PlatformSdk {
    fun init() {

        Inject.createDependencies(
            DI {
                importAll(
                    coreModule,
                    gamesModule,
                    umbrellaModule,
                    androidModule
                )
            }.direct
        )
    }
}