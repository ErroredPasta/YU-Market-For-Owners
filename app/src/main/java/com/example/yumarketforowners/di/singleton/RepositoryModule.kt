package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.data.repository.itemmanage.ItemManageRepositoryImpl
import com.example.yumarketforowners.data.repository.orderlist.OrderListRepositoryImpl
import com.example.yumarketforowners.data.repository.reviewmanage.ChatRoomRepositoryImpl
import com.example.yumarketforowners.data.repository.reviewmanage.ReviewRepositoryImpl
import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoomModel
import com.example.yumarketforowners.domain.model.reviewmanage.ReviewModel
import com.example.yumarketforowners.domain.repository.ItemManageRepository
import com.example.yumarketforowners.domain.repository.OrderListRepository
import com.example.yumarketforowners.domain.repository.ReviewOrChatRoomRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindReviewRepository(repository: ReviewRepositoryImpl):
            ReviewOrChatRoomRepository<ReviewModel>

    @Binds
    abstract fun bindChatRoomRepository(repository: ChatRoomRepositoryImpl):
            ReviewOrChatRoomRepository<ChatRoomModel>

    @Binds
    abstract fun bindItemManageRepository(repository: ItemManageRepositoryImpl): ItemManageRepository

    @Binds
    abstract fun bindOrderListRepository(repository: OrderListRepositoryImpl): OrderListRepository
}