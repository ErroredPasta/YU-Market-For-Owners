package com.example.yumarketforowners.itemmanage.data.di

import com.example.yumarketforowners.itemmanage.data.datasource.FirebaseItemRemoteDataSource
import com.example.yumarketforowners.itemmanage.data.datasource.ItemRemoteDataSource
import com.example.yumarketforowners.itemmanage.data.repository.ItemRepositoryImpl
import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ItemDataModule {

    @Binds
    fun bindItemRemoteDataSource(dataSource: FirebaseItemRemoteDataSource): ItemRemoteDataSource

    @Binds
    fun bindItemManageRepository(repository: ItemRepositoryImpl): ItemRepository
}