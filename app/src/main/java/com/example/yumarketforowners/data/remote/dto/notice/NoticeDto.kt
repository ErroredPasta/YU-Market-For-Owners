package com.example.yumarketforowners.data.remote.dto.notice

import com.example.yumarketforowners.domain.model.notice.NoticePriority
import java.time.LocalDate

// CRUD
data class NoticeDto(
    val id: Long, // not updatable
    val title: String,
    val content: String,
    val writtenAt: LocalDate,
    val priority: NoticePriority = NoticePriority.DEFAULT
)
