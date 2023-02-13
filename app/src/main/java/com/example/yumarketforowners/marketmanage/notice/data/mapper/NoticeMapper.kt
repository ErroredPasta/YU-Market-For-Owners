package com.example.yumarketforowners.marketmanage.notice.data.mapper

import com.example.yumarketforowners.marketmanage.notice.data.dto.NoticeDto
import com.example.yumarketforowners.marketmanage.notice.domain.model.Notice

fun Notice.toNoticeDto() = NoticeDto(
    id = id,
    title = title,
    content = content,
    writtenAt = writtenAt,
    priority = priority
)

fun NoticeDto.toNotice() = Notice(
    id = id,
    title = title,
    content = content,
    writtenAt = writtenAt,
    priority = priority
)