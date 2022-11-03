package com.example.yumarketforowners.presentation.mapper.notice

import com.example.yumarketforowners.domain.model.notice.Notice
import com.example.yumarketforowners.presentation.screen.marketmanage.notice.list.NoticeUiState

fun Notice.toNoticeUiState(
    onNoticeClicked: () -> Unit
) = NoticeUiState(
    id = id,
    title = title,
    content = content,
    writtenAt = writtenAt,
    priority = priority,
    onNoticeClicked = onNoticeClicked
)