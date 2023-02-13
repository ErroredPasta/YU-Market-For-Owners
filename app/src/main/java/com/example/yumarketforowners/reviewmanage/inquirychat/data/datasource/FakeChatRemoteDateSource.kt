package com.example.yumarketforowners.reviewmanage.inquirychat.data.datasource

import android.util.Log
import com.example.yumarketforowners.reviewmanage.inquirychat.data.dto.ChatDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FakeChatRemoteDateSource"

@Singleton
class FakeChatRemoteDateSource @Inject constructor() : ChatRemoteDataSource {

    private var chatList = (1..10).map {
        createChatDto(it)
    }

    private val _chatListFlow = MutableStateFlow(chatList)

    override fun getChatsByChatRoomId(chatRoomId: Long): Flow<List<ChatDto>> =
        _chatListFlow.asStateFlow()

    override suspend fun sendChat(chatRoomId: Long, chatDto: ChatDto) {
        _chatListFlow.update { chatList + chatDto.copy(id = chatList.size + 1L) }
        chatList = _chatListFlow.value
        Log.d(TAG, "sendChat: ${chatList.last()}")
    }


    // region temporary helper functions ===========================================================

    private fun createChatDto(it: Int) = ChatDto(
        id = it.toLong(),
        senderId = if (it % 3 == 0) 0L else 1L,
        message = "message $it",
        sentAt = LocalDateTime.now()
    )

    // endregion temporary helper functions ========================================================
}