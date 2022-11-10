package com.example.yumarketforowners.presentation.viewholder.chat

import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.viewholder.CellType
import java.time.LocalDateTime

data class ChatUiState(
    override val id: Long,
    override val cellType: CellType,
    val senderId: Long,
    val message: String,
    val sentAt: LocalDateTime
) : BaseViewHolderState(id, cellType)