package com.example.yumarketforowners.reviewmanage.inquirychat.data.repository

import com.example.yumarketforowners.reviewmanage.inquirychat.data.mapper.toChat
import com.example.yumarketforowners.reviewmanage.inquirychat.data.mapper.toChatDto
import com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource.ChatRemoteDataSource
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.Chat
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.repository.ChatRepository
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