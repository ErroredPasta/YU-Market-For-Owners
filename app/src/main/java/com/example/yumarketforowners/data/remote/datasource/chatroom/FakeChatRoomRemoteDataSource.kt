package com.example.yumarketforowners.data.remote.datasource.chatroom

import android.util.Log
import com.example.yumarketforowners.data.remote.dto.chatroom.ChatRoomDto
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FakeChatRoomRemoteDataSource"

@Singleton
class FakeChatRoomRemoteDataSource @Inject constructor() : ChatRoomRemoteDataSource {

    private val chatRoomList = (1..10).map {
        ChatRoomDto(
            id = it.toLong(),
            opponentName = "opponentName $it",
            opponentImageUrl = "https://picsum.photos/200",
            lastMessage = "lastMessage $it",
            createdAt = it.toLong(),
            unreadMessageCount = it
        )
    }.toMutableList()

    override suspend fun getChatRoomsByMarketId(marketId: Long): List<ChatRoomDto> {
        Log.d(TAG, "getChatRoomsByMarketId: $chatRoomList")
        return chatRoomList
    }

    override suspend fun deleteChatRoom(chatRoomId: Long) {
        chatRoomList.removeIf { it.id == chatRoomId }
//        val foundChatRoom = chatRoomList.find { it.id == chatRoomId }
//        foundChatRoom?.let { chatRoomList.remove(it) }
        Log.d(TAG, "deleteChatRoom: $chatRoomList")
    }


}