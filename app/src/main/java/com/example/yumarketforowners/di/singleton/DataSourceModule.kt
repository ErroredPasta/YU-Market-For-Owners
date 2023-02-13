package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.auth.data.datasource.FirebaseLoginRemoteDataSource
import com.example.yumarketforowners.auth.data.datasource.LoginRemoteDataSource
import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.ChatRemoteDataSource
import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.ChatRoomRemoteDataSource
import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.FakeChatRemoteDateSource
import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.FakeChatRoomRemoteDataSource
import com.example.yumarketforowners.itemmanage.data.datasource.FirebaseItemRemoteDataSource
import com.example.yumarketforowners.itemmanage.data.datasource.ItemRemoteDataSource
import com.example.yumarketforowners.marketmanage.market.data.datasource.MarketRemoteDataSource
import com.example.yumarketforowners.marketmanage.market.data.datasource.MarketRemoteDataSourceImpl
import com.example.yumarketforowners.marketmanage.notice.data.datasource.FakeNoticeRemoteDataSource
import com.example.yumarketforowners.marketmanage.notice.data.datasource.NoticeRemoteDataSource
import com.example.yumarketforowners.orderlist.data.datasource.FakeOrderRemoteDataSource
import com.example.yumarketforowners.orderlist.data.datasource.OrderRemoteDataSource
import com.example.yumarketforowners.reviewmanage.review.data.datasource.FirebaseReviewRemoteDataSource
import com.example.yumarketforowners.reviewmanage.review.data.datasource.ReviewRemoteDataSource
import com.example.yumarketforowners.auth.data.datasource.FakeUserRemoteDataSource
import com.example.yumarketforowners.auth.data.datasource.UserRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {
    @Binds
    fun bindChatRoomRemoteDataSource(dataSource: FakeChatRoomRemoteDataSource): ChatRoomRemoteDataSource

    @Binds
    fun bindItemRemoteDataSource(dataSource: FirebaseItemRemoteDataSource): ItemRemoteDataSource

    @Binds
    fun bindOrderRemoteDataSource(dataSource: FakeOrderRemoteDataSource): OrderRemoteDataSource

    @Binds
    fun bindReviewRemoteDataSource(dataSource: FirebaseReviewRemoteDataSource): ReviewRemoteDataSource

    @Binds
    fun bindMarketRemoteDataSource(dateSource: MarketRemoteDataSourceImpl): MarketRemoteDataSource

    @Binds
    fun bindNoticeRemoteDataSource(dataSource: FakeNoticeRemoteDataSource): NoticeRemoteDataSource

    @Binds
    @Singleton
    fun bindUserRemoteDataSource(dataSource: FakeUserRemoteDataSource): UserRemoteDataSource

    @Binds
    fun bindChatRemoteDataSource(dataSource: FakeChatRemoteDateSource): ChatRemoteDataSource

    @Binds
    fun bindLoginRemoteDataSource(authManager: FirebaseLoginRemoteDataSource): LoginRemoteDataSource
}