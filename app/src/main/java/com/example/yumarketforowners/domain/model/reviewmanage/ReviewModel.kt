package com.example.yumarketforowners.domain.model.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.domain.model.BaseModel
import com.example.yumarketforowners.domain.model.orderlist.OrderModel

data class ReviewModel(
    override val id: Long,
    val writer: String,
    val profileImageUrl: String,
    val content: String,
    val order: OrderModel,
    val writeTime: Long,
    val reply: ReplyModel? = null
) : BaseModel(id, CellType.REVIEW_CELL)
