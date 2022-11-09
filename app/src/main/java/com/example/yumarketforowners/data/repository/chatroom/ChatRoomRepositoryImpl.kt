package com.example.yumarketforowners.data.repository.chatroom

import com.example.yumarketforowners.data.mapper.chatroom.toChatRoom
import com.example.yumarketforowners.data.remote.datasource.chatroom.ChatRoomRemoteDataSource
import com.example.yumarketforowners.domain.model.chatroom.ChatRoom
import com.example.yumarketforowners.domain.repository.chatroom.ChatRoomRepository
import javax.inject.Inject

class ChatRoomRepositoryImpl @Inject constructor(
    private val dataSource: ChatRoomRemoteDataSource
) : ChatRoomRepository {

    override suspend fun getAllChatRoomsByMarketId(marketId: Long): List<ChatRoom> =
        dataSource.getChatRoomsByMarketId(marketId).map { it.toChatRoom() }

    override suspend fun deleteChatRoom(chatRoomId: Long) = dataSource.deleteChatRoom(chatRoomId)
}