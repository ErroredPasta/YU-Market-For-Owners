package com.example.yumarketforowners.domain.repository

import com.example.yumarketforowners.domain.model.BaseModel
import com.example.yumarketforowners.presentation.screen.reviewmanage.ReviewManageContract

interface ReviewOrChatRoomRepository<M : BaseModel> {
    fun getAllByMarketId(marketId: Long): List<M>
}