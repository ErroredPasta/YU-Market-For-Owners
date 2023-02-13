package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.di.qualifier.LoginRepositoryQualifier
import com.example.yumarketforowners.di.qualifier.LoginRepositoryType
import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import com.example.yumarketforowners.reviewmanage.review.domain.repository.ReviewRepository
import com.example.yumarketforowners.auth.domain.repository.LoginRepository
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRepository
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRoomRepository
import com.example.yumarketforowners.marketmanage.market.domain.repository.MarketRepository
import com.example.yumarketforowners.marketmanage.notice.domain.repository.NoticeRepository
import com.example.yumarketforowners.auth.domain.repository.UserRepository
import com.example.yumarketforowners.auth.domain.usecase.GoogleLoginUseCase
import com.example.yumarketforowners.auth.domain.usecase.KakaoLoginUseCase
import com.example.yumarketforowners.auth.domain.usecase.LoginUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.GetChatRoomsUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.GetChatsByChatRoomIdUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.RemoveChatRoomUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.SendChatUseCase
import com.example.yumarketforowners.itemmanage.domain.usecase.AddItemUseCase
import com.example.yumarketforowners.itemmanage.domain.usecase.GetItemsUseCase
import com.example.yumarketforowners.itemmanage.domain.usecase.GetSingleItemUseCase
import com.example.yumarketforowners.itemmanage.domain.usecase.UpdateItemUseCase
import com.example.yumarketforowners.marketmanage.market.domain.usecase.GetMarketDetailUseCase
import com.example.yumarketforowners.marketmanage.market.domain.usecase.UpdateMarketUseCase
import com.example.yumarketforowners.marketmanage.notice.domain.usecase.GetAllNoticesUseCase
import com.example.yumarketforowners.marketmanage.notice.domain.usecase.GetNoticeByIdUseCase
import com.example.yumarketforowners.orderlist.domain.usecase.GetOrderListUseCase
import com.example.yumarketforowners.orderlist.domain.usecase.UpdateOrderStateUseCase
import com.example.yumarketforowners.reviewmanage.review.domain.usecase.GetReviewsUseCase
import com.example.yumarketforowners.auth.domain.usecase.GetCurrentUserUseCase
import com.example.yumarketforowners.auth.domain.usecase.UpdateUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetChatRoomsUseCase(repository: ChatRoomRepository) = GetChatRoomsUseCase(repository)

    @Provides
    fun provideGetItemsUseCase(repository: ItemRepository) = GetItemsUseCase(repository)

    @Provides
    fun provideGetOrderListUseCase(repository: OrderRepository) = GetOrderListUseCase(repository)

    @Provides
    fun provideGetReviewsUseCase(repository: ReviewRepository) = GetReviewsUseCase(repository)

    @Provides
    fun provideGetMarketDetailUseCase(repository: MarketRepository) =
        GetMarketDetailUseCase(repository)

    @Provides
    fun provideUpdateMarketUseCase(repository: MarketRepository) = UpdateMarketUseCase(repository)

    @Provides
    fun provideUpdateOrderStateUseCase(repository: OrderRepository) =
        UpdateOrderStateUseCase(repository)

    @Provides
    fun provideRemoveChatRoomUseCase(repository: ChatRoomRepository) =
        RemoveChatRoomUseCase(repository)

    @Provides
    fun provideGetSingleItemUseCase(repository: ItemRepository) = GetSingleItemUseCase(repository)

    @Provides
    fun provideUpdateItemUseCase(repository: ItemRepository) = UpdateItemUseCase(repository)

    @Provides
    fun provideGetAllNoticesUseCase(repository: NoticeRepository) = GetAllNoticesUseCase(repository)

    @Provides
    fun provideGetNoticeByIdUseCase(repository: NoticeRepository) = GetNoticeByIdUseCase(repository)

    @Provides
    fun provideGetCurrentUserUseCase(repository: UserRepository) = GetCurrentUserUseCase(repository)

    @Provides
    fun provideUpdateUserUseCase(repository: UserRepository) = UpdateUserUseCase(repository)

    @Provides
    fun provideGetChatsByChatRoomIdUseCase(repository: ChatRepository) =
        GetChatsByChatRoomIdUseCase(repository)

    @Provides
    fun provideSendChatUseCase(repository: ChatRepository) = SendChatUseCase(repository)

    @Provides
    fun provideAddItemUseCase(repository: ItemRepository) = AddItemUseCase(repository)

    @Provides
    fun provideLoginUseCase(
        @LoginRepositoryQualifier(LoginRepositoryType.DEFAULT) repository: LoginRepository
    ) = LoginUseCase(repository)

    @Provides
    fun provideKakaoLoginUseCase(
        @LoginRepositoryQualifier(LoginRepositoryType.KAKAO) repository: LoginRepository
    ) = KakaoLoginUseCase(repository)

    @Provides
    fun provideGoogleLoginUseCase(
        @LoginRepositoryQualifier(LoginRepositoryType.GOOGLE) repository: LoginRepository
    ) = GoogleLoginUseCase(repository)
}