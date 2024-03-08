package com.observer.playzone.android.presentation.activity

import GamesRepository
import Inject.instance
import android.os.Bundle

import androidx.activity.ComponentActivity
import kotlinx.coroutines.CoroutineScope


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gamesRepository = instance<GamesRepository>()

        CoroutineScope()

    }
}

