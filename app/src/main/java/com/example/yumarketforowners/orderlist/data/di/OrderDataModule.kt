package com.example.yumarketforowners.orderlist.data.di

import com.example.yumarketforowners.orderlist.data.datasource.FakeOrderRemoteDataSource
import com.example.yumarketforowners.orderlist.data.datasource.OrderRemoteDataSource
import com.example.yumarketforowners.orderlist.data.repository.OrderRepositoryImpl
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface OrderDataModule {

    @Binds
    fun bindOrderRemoteDataSource(dataSource: FakeOrderRemoteDataSource): OrderRemoteDataSource

    @Binds
    fun bindOrderListRepository(repository: OrderRepositoryImpl): OrderRepository
}