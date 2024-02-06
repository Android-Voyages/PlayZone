package com.observer.playzone.presentation.viewmodel

import GamesRepository
import Inject.instance
import androidx.lifecycle.ViewModel
import coroutine.AppDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val dispatchers: AppDispatchers) : ViewModel() {

    internal fun searchGame() {
        val gamesRepository = instance<GamesRepository>()

        CoroutineScope(context = Job() + dispatchers.io).launch {
            val game = gamesRepository.searchGame("")

            withContext(Job() + dispatchers.main) {

            }
        }
    }
}