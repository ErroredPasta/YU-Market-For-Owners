package com.example.yumarketforowners.presentation.screen.base

import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

abstract class BaseCoroutinePresenter(
    private val scopeProvider: Provider<CoroutineScope>
) {
    protected val coroutineScope: CoroutineScope get() = scopeProvider.get()
}