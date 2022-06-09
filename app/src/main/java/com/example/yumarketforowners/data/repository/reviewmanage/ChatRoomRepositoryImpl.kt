package com.example.yumarketforowners.data.repository.reviewmanage

import com.example.yumarketforowners.data.model.reviewmanage.ChatRoomModel
import com.example.yumarketforowners.screen.reviewmanage.ReviewManageContract
import com.example.yumarketforowners.screen.reviewmanage.ReviewManageContract.State
import javax.inject.Inject

class ChatRoomRepositoryImpl @Inject constructor() : ReviewOrChatRoomRepository<ChatRoomModel> {
    private val testList get() = (0..9).map {
        ChatRoomModel(
            id = it.toLong(),
            opponentName = "name $it",
            opponentImageUrl = "https://picsum.photos/200",
            lastMessage = "last message $it",
            createdTime = System.currentTimeMillis(),
            unreadMessageCount = it
        )
    }

    override fun getAllByMarketId(marketId: Long): State = State.Success(data = testList)
}