package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.auth.data.repository.DefaultLoginRepository
import com.example.yumarketforowners.auth.data.repository.GoogleLoginRepository
import com.example.yumarketforowners.auth.data.repository.KakaoLoginRepository
import com.example.yumarketforowners.reviewmanage.inquirychat.data.repository.ChatRepositoryImpl
import com.example.yumarketforowners.reviewmanage.inquirychat.data.repository.ChatRoomRepositoryImpl
import com.example.yumarketforowners.marketmanage.customersupport.data.repository.FakeCustomerSupportRepository
import com.example.yumarketforowners.itemmanage.data.repository.ItemRepositoryImpl
import com.example.yumarketforowners.marketmanage.market.data.repository.MarketRepositoryImpl
import com.example.yumarketforowners.marketmanage.notice.data.repository.NoticeRepositoryImpl
import com.example.yumarketforowners.orderlist.data.repository.OrderRepositoryImpl
import com.example.yumarketforowners.reviewmanage.review.data.repository.ReviewRepositoryImpl
import com.example.yumarketforowners.auth.data.repository.UserRepositoryImpl
import com.example.yumarketforowners.di.qualifier.LoginRepositoryQualifier
import com.example.yumarketforowners.di.qualifier.LoginRepositoryType
import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import com.example.yumarketforowners.reviewmanage.review.domain.repository.ReviewRepository
import com.example.yumarketforowners.auth.domain.repository.LoginRepository
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRepository
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRoomRepository
import com.example.yumarketforowners.marketmanage.customersupport.domain.repository.CustomerSupportRepository
import com.example.yumarketforowners.marketmanage.market.domain.repository.MarketRepository
import com.example.yumarketforowners.marketmanage.notice.domain.repository.NoticeRepository
import com.example.yumarketforowners.auth.domain.repository.UserRepository
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

    @Binds
    fun bindCustomerSupportRepository(repository: FakeCustomerSupportRepository): CustomerSupportRepository
}