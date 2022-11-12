package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.data.remote.datasource.chatroom.ChatRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.chatroom.ChatRoomRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.chatroom.FakeChatRemoteDateSource
import com.example.yumarketforowners.data.remote.datasource.chatroom.FakeChatRoomRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.item.FakeItemRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.item.ItemRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.market.MarketRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.market.MarketRemoteDataSourceImpl
import com.example.yumarketforowners.data.remote.datasource.notice.FakeNoticeRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.notice.NoticeRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.order.FakeOrderRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.order.OrderRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.review.FakeReviewRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.review.ReviewRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.user.FakeUserRemoteDataSource
import com.example.yumarketforowners.data.remote.datasource.user.UserRemoteDataSource
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
    fun bindMarketRemoteDataSource(dateSource: MarketRemoteDataSourceImpl): MarketRemoteDataSource

    @Binds
    fun bindNoticeRemoteDataSource(dataSource: FakeNoticeRemoteDataSource): NoticeRemoteDataSource

    @Binds
    fun bindUserRemoteDataSource(dataSource: FakeUserRemoteDataSource): UserRemoteDataSource

    @Binds
    fun bindChatRemoteDataSource(dataSource: FakeChatRemoteDateSource): ChatRemoteDataSource
}