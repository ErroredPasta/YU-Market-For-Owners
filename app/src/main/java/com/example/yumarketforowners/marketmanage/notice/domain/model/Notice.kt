package com.example.yumarketforowners.marketmanage.notice.domain.model

import java.time.LocalDate

data class Notice(
    val id: Long,
    val title: String,
    val content: String,
    val writtenAt: LocalDate,
    val priority: NoticePriority
)
