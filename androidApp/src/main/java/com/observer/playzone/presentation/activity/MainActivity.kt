package com.observer.playzone.presentation.activity


import GamesRepository
import Inject.instance
import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import navigation.setupThemedNavigation


class MainActivity() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupThemedNavigation()
    }
}

