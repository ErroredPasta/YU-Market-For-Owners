package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.data.repository.auth.DefaultLoginRepository
import com.example.yumarketforowners.data.repository.auth.GoogleLoginRepository
import com.example.yumarketforowners.data.repository.auth.KakaoLoginRepository
import com.example.yumarketforowners.data.repository.chatroom.ChatRepositoryImpl
import com.example.yumarketforowners.data.repository.chatroom.ChatRoomRepositoryImpl
import com.example.yumarketforowners.data.repository.item.ItemRepositoryImpl
import com.example.yumarketforowners.data.repository.market.MarketRepositoryImpl
import com.example.yumarketforowners.data.repository.notice.NoticeRepositoryImpl
import com.example.yumarketforowners.data.repository.order.OrderRepositoryImpl
import com.example.yumarketforowners.data.repository.review.ReviewRepositoryImpl
import com.example.yumarketforowners.data.repository.user.UserRepositoryImpl
import com.example.yumarketforowners.di.qualifier.LoginRepositoryQualifier
import com.example.yumarketforowners.di.qualifier.LoginRepositoryType
import com.example.yumarketforowners.domain.repository.ItemRepository
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.domain.repository.ReviewRepository
import com.example.yumarketforowners.domain.repository.auth.LoginRepository
import com.example.yumarketforowners.domain.repository.chatroom.ChatRepository
import com.example.yumarketforowners.domain.repository.chatroom.ChatRoomRepository
import com.example.yumarketforowners.domain.repository.market.MarketRepository
import com.example.yumarketforowners.domain.repository.notice.NoticeRepository
import com.example.yumarketforowners.domain.repository.user.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindReviewRepository(repository: ReviewRepositoryImpl): ReviewRepository

    @Binds
    fun bindChatRoomRepository(repository: ChatRoomRepositoryImpl): ChatRoomRepository

    @Binds
    fun bindItemManageRepository(repository: ItemRepositoryImpl): ItemRepository

    @Binds
    fun bindOrderListRepository(repository: OrderRepositoryImpl): OrderRepository

    @Binds
    fun bindMarketRepository(repository: MarketRepositoryImpl): MarketRepository

    @Binds
    fun bindNoticeRepository(repository: NoticeRepositoryImpl): NoticeRepository

    @Binds
    fun bindUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    fun bindChatRepository(repository: ChatRepositoryImpl): ChatRepository

    @Binds
    @LoginRepositoryQualifier(LoginRepositoryType.DEFAULT)
    fun bindDefaultLoginRepository(repository: DefaultLoginRepository): LoginRepository

    @Binds
    @LoginRepositoryQualifier(LoginRepositoryType.KAKAO)
    fun bindKakaoLoginRepository(repository: KakaoLoginRepository): LoginRepository

    @Binds
    @LoginRepositoryQualifier(LoginRepositoryType.GOOGLE)
    fun bindGoogleLoginRepository(repository: GoogleLoginRepository): LoginRepository
}