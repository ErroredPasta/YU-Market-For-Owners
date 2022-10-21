package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.data.remote.api.TMapApi
import com.example.yumarketforowners.data.remote.api.TMapApiStub
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Binds
    @Singleton
    fun bindTMapApiInterface(api: TMapApiStub): TMapApi
}