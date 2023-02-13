package com.example.yumarketforowners.di.activity

import com.example.yumarketforowners.core.presentation.base.BaseView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineExceptionHandler

@Module
@InstallIn(ActivityComponent::class)
object ExceptionHandlerModule {

    @Provides
    fun provideDefaultExceptionHandler(
        view: BaseView
    ) = CoroutineExceptionHandler { _, throwable ->
        view.onError(throwable)
        throwable.printStackTrace()
    }
}