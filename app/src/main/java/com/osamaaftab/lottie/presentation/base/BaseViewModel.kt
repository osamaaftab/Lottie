package com.osamaaftab.lottie.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {

    val scope = CoroutineScope(
        Job() + Dispatchers.Main
    )

    val featuredUsecaseToken = "f6e406f5-befb-40ab-a9b0-bb0a773b09fd"
    val recentUsecaseToken = "f5acfd96-384a-4552-a0b5-399675a03826"
    val popularUsecaseToken = "a32b4948-d278-4923-880e-8fb57741c190"
    val animatorsUsecaseToken = "5b3e8205-b317-45c4-a5ce-36c9dc57911d"

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}