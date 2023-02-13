package com.example.yumarketforowners.reviewmanage.inquirychat.domain.model

data class ChatRoom(
    val id: Long,
    val opponentName: String,
    val opponentImageUrl: String?,
    val lastMessage: String,
    val createdTime: Long,
    val unreadMessageCount: Int
)
