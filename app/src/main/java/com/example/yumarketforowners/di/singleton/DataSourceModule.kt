package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.data.remote.datasource.chatroom.ChatRoomRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.chatroom.FakeChatRoomRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.item.FakeItemRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.item.ItemRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.order.FakeOrderRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.order.OrderRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.review.FakeReviewRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.review.ReviewRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindChatRoomRemoteDataSource(dataSource: FakeChatRoomRemoteDataSource): ChatRoomRemoteDataSource

    @Binds
    abstract fun bindItemRemoteDataSource(dataSource: FakeItemRemoteDataSource): ItemRemoteDataSource

    @Binds
    abstract fun bindOrderRemoteDataSource(dataSource: FakeOrderRemoteDataSource): OrderRemoteDataSource

    @Binds
    abstract fun bindReviewRemoteDataSource(dataSource: FakeReviewRemoteDataSource): ReviewRemoteDataSource
}