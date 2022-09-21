package com.example.yumarketforowners.data.repository.reviewmanage

import com.example.yumarketforowners.di.singleton.Dispatcher
import com.example.yumarketforowners.di.singleton.DispatcherType
import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import com.example.yumarketforowners.domain.repository.ChatRoomRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ChatRoomRepositoryImpl @Inject constructor(
    @Dispatcher(DispatcherType.IO) private val dispatcher: CoroutineDispatcher
) : ChatRoomRepository {
    private val testList
        get() = (0..9).map {
            ChatRoom(
                id = it.toLong(),
                opponentName = "name $it",
                opponentImageUrl = "https://picsum.photos/200",
                lastMessage = "last message $it",
                createdTime = System.currentTimeMillis(),
                unreadMessageCount = it
            )
        }

    override suspend fun getAllChatRoomsByMarketId(marketId: Long): List<ChatRoom> =
        withContext(dispatcher) {
            testList
        }
}