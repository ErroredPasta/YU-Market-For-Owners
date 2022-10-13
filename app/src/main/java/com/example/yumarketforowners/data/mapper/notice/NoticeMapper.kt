package com.example.yumarketforowners.data.mapper.notice

import com.example.yumarketforowners.data.remote.dto.notice.NoticeDto
import com.example.yumarketforowners.domain.model.notice.Notice

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