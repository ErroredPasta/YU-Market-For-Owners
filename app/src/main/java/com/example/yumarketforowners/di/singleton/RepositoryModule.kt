package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.data.repository.itemmanage.ItemRepositoryImpl
import com.example.yumarketforowners.data.repository.orderlist.OrderRepositoryImpl
import com.example.yumarketforowners.data.repository.reviewmanage.ChatRoomRepositoryImpl
import com.example.yumarketforowners.data.repository.reviewmanage.ReviewRepositoryImpl
import com.example.yumarketforowners.domain.repository.ChatRoomRepository
import com.example.yumarketforowners.domain.repository.ItemRepository
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.domain.repository.ReviewRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindReviewRepository(repository: ReviewRepositoryImpl):
            ReviewRepository

    @Binds
    abstract fun bindChatRoomRepository(repository: ChatRoomRepositoryImpl):
            ChatRoomRepository

    @Binds
    abstract fun bindItemManageRepository(repository: ItemRepositoryImpl): ItemRepository

    @Binds
    abstract fun bindOrderListRepository(repository: OrderRepositoryImpl): OrderRepository
}