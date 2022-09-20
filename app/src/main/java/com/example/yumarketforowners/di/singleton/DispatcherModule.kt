package com.example.yumarketforowners.di.singleton

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @Provides
    @Singleton
    @Dispatcher(DispatcherType.IO)
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}

annotation class Dispatcher(val type: DispatcherType)

enum class DispatcherType {
    IO
}
