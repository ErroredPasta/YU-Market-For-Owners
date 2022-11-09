package com.example.yumarketforowners.data.repository.chatroom

import com.example.yumarketforowners.data.mapper.chatroom.toChat
import com.example.yumarketforowners.data.mapper.chatroom.toChatDto
import com.example.yumarketforowners.data.remote.datasource.chatroom.ChatRemoteDataSource
import com.example.yumarketforowners.domain.model.chatroom.Chat
import com.example.yumarketforowners.domain.repository.chatroom.ChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val remoteDataSource: ChatRemoteDataSource
) : ChatRepository {

    override fun getChatsByChatRoomId(chatRoomId: Long): Flow<List<Chat>> =
        remoteDataSource.getChatsByChatRoomId(chatRoomId = chatRoomId).map { chatDtos ->
            chatDtos.map { chatDto -> chatDto.toChat() }
        }

    override suspend fun sendChat(chatRoomId: Long, chat: Chat) =
        remoteDataSource.sendChat(chatRoomId = chatRoomId, chatDto = chat.toChatDto())
}