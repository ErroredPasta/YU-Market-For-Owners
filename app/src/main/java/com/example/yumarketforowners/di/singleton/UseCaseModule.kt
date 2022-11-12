package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.domain.repository.ItemRepository
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.domain.repository.ReviewRepository
import com.example.yumarketforowners.domain.repository.chatroom.ChatRepository
import com.example.yumarketforowners.domain.repository.chatroom.ChatRoomRepository
import com.example.yumarketforowners.domain.repository.market.MarketRepository
import com.example.yumarketforowners.domain.repository.notice.NoticeRepository
import com.example.yumarketforowners.domain.repository.user.UserRepository
import com.example.yumarketforowners.domain.usecase.auth.LoginUseCase
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatRoomsUseCase
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatsByChatRoomIdUseCase
import com.example.yumarketforowners.domain.usecase.chatroom.RemoveChatRoomUseCase
import com.example.yumarketforowners.domain.usecase.chatroom.SendChatUseCase
import com.example.yumarketforowners.domain.usecase.item.AddItemUseCase
import com.example.yumarketforowners.domain.usecase.item.GetItemsUseCase
import com.example.yumarketforowners.domain.usecase.item.GetSingleItemUseCase
import com.example.yumarketforowners.domain.usecase.item.UpdateItemUseCase
import com.example.yumarketforowners.domain.usecase.market.GetMarketDetailUseCase
import com.example.yumarketforowners.domain.usecase.market.UpdateMarketUseCase
import com.example.yumarketforowners.domain.usecase.notice.GetAllNoticesUseCase
import com.example.yumarketforowners.domain.usecase.notice.GetNoticeByIdUseCase
import com.example.yumarketforowners.domain.usecase.order.GetOrderListUseCase
import com.example.yumarketforowners.domain.usecase.order.UpdateOrderStateUseCase
import com.example.yumarketforowners.domain.usecase.review.GetReviewsUseCase
import com.example.yumarketforowners.domain.usecase.user.GetCurrentUserUseCase
import com.example.yumarketforowners.domain.usecase.user.UpdateUserUseCase
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
    fun provideLoginUseCase(repository: UserRepository) = LoginUseCase(repository)
}