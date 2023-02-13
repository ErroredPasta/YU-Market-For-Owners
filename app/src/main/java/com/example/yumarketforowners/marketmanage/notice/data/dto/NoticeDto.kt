package com.example.yumarketforowners.marketmanage.notice.data.dto

import com.example.yumarketforowners.marketmanage.notice.domain.model.NoticePriority
import java.time.LocalDate

// CRUD
data class NoticeDto(
    val id: Long, // not updatable
    val title: String,
    val content: String,
    val writtenAt: LocalDate,
    val priority: NoticePriority = NoticePriority.DEFAULT
)
