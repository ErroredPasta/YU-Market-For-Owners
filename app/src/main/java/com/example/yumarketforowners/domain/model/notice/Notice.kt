package com.example.yumarketforowners.domain.model.notice

data class Notice(
    val id: Long,
    val title: String,
    val content: String,
    val writtenAt: Long,
    val priority: NoticePriority
)
