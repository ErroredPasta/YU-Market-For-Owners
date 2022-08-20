package com.example.yumarketforowners.domain.model.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.domain.model.BaseModel

data class ChatRoomModel(
    override val id: Long,
    val opponentName: String,
    val opponentImageUrl: String,
    val lastMessage: String,
    val createdTime: Long,
    var unreadMessageCount: Int
) : BaseModel(id, CellType.CHAT_ROOM_CELL)
