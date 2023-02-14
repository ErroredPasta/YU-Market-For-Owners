package com.example.yumarketforowners.marketmanage.market.data.di

import com.example.yumarketforowners.marketmanage.market.data.datasource.MarketRemoteDataSource
import com.example.yumarketforowners.marketmanage.market.data.datasource.MarketRemoteDataSourceImpl
import com.example.yumarketforowners.marketmanage.market.data.repository.MarketRepositoryImpl
import com.example.yumarketforowners.marketmanage.market.domain.repository.MarketRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MarketDataModule {

    @Binds
    fun bindMarketRemoteDataSource(dateSource: MarketRemoteDataSourceImpl): MarketRemoteDataSource

    @Binds
    fun bindMarketRepository(repository: MarketRepositoryImpl): MarketRepository
}