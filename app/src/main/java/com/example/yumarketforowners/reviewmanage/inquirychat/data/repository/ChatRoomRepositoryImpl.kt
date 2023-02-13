package com.example.yumarketforowners.reviewmanage.inquirychat.data.repository

import com.example.yumarketforowners.reviewmanage.inquirychat.data.mapper.toChatRoom
import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.ChatRoomRemoteDataSource
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.ChatRoom
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRoomRepository
import javax.inject.Inject

class ChatRoomRepositoryImpl @Inject constructor(
    private val dataSource: ChatRoomRemoteDataSource
) : ChatRoomRepository {

    override suspend fun getAllChatRoomsByMarketId(marketId: Long): List<ChatRoom> =
        dataSource.getChatRoomsByMarketId(marketId).map { it.toChatRoom() }

    override suspend fun deleteChatRoom(chatRoomId: Long) = dataSource.deleteChatRoom(chatRoomId)
}