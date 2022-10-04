package com.example.yumarketforowners.data.repository.chatroom

import com.example.yumarketforowners.data.remote.chatroom.ChatRoomRemoteDataSource
import com.example.yumarketforowners.domain.repository.ChatRoomRepository
import javax.inject.Inject

class ChatRoomRepositoryImpl @Inject constructor(
    private val dataSource: ChatRoomRemoteDataSource
) : ChatRoomRepository {

    override suspend fun getAllChatRoomsByMarketId(marketId: Long) =
        dataSource.getChatRoomsByMarketId(marketId)
}