package com.example.yumarketforowners.core.presentation.base

import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

abstract class BaseCoroutinePresenter(
    private val scopeProvider: Provider<CoroutineScope>
) {

    protected open val coroutineScope: CoroutineScope
        get() = scopeProvider.get()
}