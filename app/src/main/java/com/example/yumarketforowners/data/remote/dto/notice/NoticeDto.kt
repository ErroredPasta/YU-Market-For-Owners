package com.example.yumarketforowners.data.remote.dto.notice

import com.example.yumarketforowners.domain.model.notice.NoticePriority

// CRUD
data class NoticeDto(
    val id: Long, // not updatable
    val title: String,
    val content: String,
    val writtenAt: Long,
    val priority: NoticePriority = NoticePriority.DEFAULT
)
