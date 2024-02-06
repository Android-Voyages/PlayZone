package com.observer.playzone.di

import com.observer.playzone.presentation.viewmodel.MainViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val androidModule = DI.Module("androidModule") {
    bind<MainViewModel>() with singleton { MainViewModel(instance()) }
}
