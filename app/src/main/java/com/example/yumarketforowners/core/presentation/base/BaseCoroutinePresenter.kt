package com.example.yumarketforowners.core.presentation.base

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.plus
import javax.inject.Provider

abstract class BaseCoroutinePresenter(
    baseView: BaseView,
    private val scopeProvider: Provider<CoroutineScope>
) {
    /**
     * 기본적으로 Provider<CoroutineScope>에서 가져오는 scope와 exception handler를 합친 CoroutineScope
     * 필요시 override할 수 있도록 open으로 설정
     */
    protected open val coroutineScope: CoroutineScope
        get() = scopeProvider.get() + exceptionHandler


    /**
     * 기본적인 CoroutineExceptionHandler
     * BaseView에서 처리되지 않은 throwable을 넘겨주어 처리할 수 있도록 한다.
     * 필요시 override할 수 있도록 open으로 설정
     */
    protected open val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        baseView.onError(throwable = throwable)
        throwable.printStackTrace()
    }
}