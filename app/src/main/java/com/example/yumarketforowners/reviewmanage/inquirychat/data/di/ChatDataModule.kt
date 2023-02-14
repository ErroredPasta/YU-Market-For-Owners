package com.example.yumarketforowners.reviewmanage.inquirychat.data.di

import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.ChatRemoteDataSource
import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.ChatRoomRemoteDataSource
import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.FakeChatRemoteDateSource
import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.FakeChatRoomRemoteDataSource
import com.example.yumarketforowners.reviewmanage.inquirychat.data.repository.ChatRepositoryImpl
import com.example.yumarketforowners.reviewmanage.inquirychat.data.repository.ChatRoomRepositoryImpl
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRepository
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRoomRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface ChatDataModule {

    @Binds
    fun bindChatRoomRemoteDataSource(dataSource: FakeChatRoomRemoteDataSource): ChatRoomRemoteDataSource

    @Binds
    fun bindChatRemoteDataSource(dataSource: FakeChatRemoteDateSource): ChatRemoteDataSource

    @Binds
    fun bindChatRoomRepository(repository: ChatRoomRepositoryImpl): ChatRoomRepository

    @Binds
    fun bindChatRepository(repository: ChatRepositoryImpl): ChatRepository
}