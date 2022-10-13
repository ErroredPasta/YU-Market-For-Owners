package com.example.yumarketforowners.entity

import com.example.yumarketforowners.domain.model.chatroom.ChatRoom

fun createChatRoom(it: Int) = ChatRoom(
    id = it.toLong(),
    opponentName = "opponentName $it",
    opponentImageUrl = "opponentImageUrl $it",
    lastMessage = "lastMessage $it",
    createdTime = it.toLong(),
    unreadMessageCount = it
)
