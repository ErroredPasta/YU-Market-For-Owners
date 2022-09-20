package com.example.yumarketforowners.domain.model.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.domain.model.BaseModel
import com.example.yumarketforowners.domain.model.orderlist.Order

data class Review(
    override val id: Long,
    val writer: String,
    val profileImageUrl: String,
    val content: String,
    val order: Order,
    val writeTime: Long,
    val reply: Reply? = null
) : BaseModel(id, CellType.REVIEW_CELL)
