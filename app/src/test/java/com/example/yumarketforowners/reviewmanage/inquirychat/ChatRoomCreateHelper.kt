package com.example.yumarketforowners.reviewmanage.inquirychat

import com.example.yumarketforowners.reviewmanage.inquirychat.domain.model.ChatRoom

fun createChatRoom(it: Int) = ChatRoom(
    id = it.toLong(),
    opponentName = "opponentName $it",
    opponentImageUrl = "opponentImageUrl $it",
    lastMessage = "lastMessage $it",
    createdTime = it.toLong(),
    unreadMessageCount = it
)
