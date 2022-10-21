package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.data.remote.datasource.chatroom.ChatRoomRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.chatroom.FakeChatRoomRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.item.FakeItemRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.item.ItemRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.market.FakeMarketRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.market.MarketRemoteDataSource
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
interface DataSourceModule {
    @Binds
    fun bindChatRoomRemoteDataSource(dataSource: FakeChatRoomRemoteDataSource): ChatRoomRemoteDataSource

    @Binds
    fun bindItemRemoteDataSource(dataSource: FakeItemRemoteDataSource): ItemRemoteDataSource

    @Binds
    fun bindOrderRemoteDataSource(dataSource: FakeOrderRemoteDataSource): OrderRemoteDataSource

    @Binds
    fun bindReviewRemoteDataSource(dataSource: FakeReviewRemoteDataSource): ReviewRemoteDataSource

    @Binds
    fun bindMarketRemoteDataSource(dateSource: FakeMarketRemoteDataSource): MarketRemoteDataSource
}