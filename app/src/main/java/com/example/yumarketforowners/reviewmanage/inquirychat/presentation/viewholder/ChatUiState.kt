package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.viewholder

import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.CellType
import java.time.LocalDateTime

data class ChatUiState(
    override val id: Long,
    override val cellType: CellType,
    val senderId: Long,
    val message: String,
    val sentAt: LocalDateTime
) : BaseViewHolderState(id, cellType)