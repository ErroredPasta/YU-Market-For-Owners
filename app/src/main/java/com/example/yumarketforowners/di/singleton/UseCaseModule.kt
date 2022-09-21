package com.example.yumarketforowners.di.singleton

import com.example.yumarketforowners.domain.repository.ChatRoomRepository
import com.example.yumarketforowners.domain.repository.ItemRepository
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.domain.repository.ReviewRepository
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatRooms
import com.example.yumarketforowners.domain.usecase.item.GetItems
import com.example.yumarketforowners.domain.usecase.order.GetOrderList
import com.example.yumarketforowners.domain.usecase.review.GetReviews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetChatRoomsUseCase(repository: ChatRoomRepository) = GetChatRooms(repository)

    @Provides
    fun provideGetItemsUseCase(repository: ItemRepository) = GetItems(repository)

    @Provides
    fun provideGetOrderListUseCase(repository: OrderRepository) = GetOrderList(repository)

    @Provides
    fun provideGetReviewsUseCase(repository: ReviewRepository) = GetReviews(repository)
}