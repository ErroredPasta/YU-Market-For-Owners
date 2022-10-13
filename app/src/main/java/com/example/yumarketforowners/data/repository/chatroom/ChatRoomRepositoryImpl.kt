package com.example.yumarketforowners.data.repository.chatroom

import com.example.yumarketforowners.data.mapper.chatroom.toChatRoom
import com.example.yumarketforowners.data.remote.datasource.chatroom.ChatRoomRemoteDataSource
import com.example.yumarketforowners.domain.repository.ChatRoomRepository
import javax.inject.Inject

class ChatRoomRepositoryImpl @Inject constructor(
    private val dataSource: ChatRoomRemoteDataSource
) : ChatRoomRepository {

    override suspend fun getAllChatRoomsByMarketId(marketId: Long) =
        dataSource.getChatRoomsByMarketId(marketId).map { it.toChatRoom() }
}