package com.example.yumarketforowners.marketmanage.notice.presentation.mapper

import com.example.yumarketforowners.marketmanage.notice.domain.model.Notice
import com.example.yumarketforowners.marketmanage.notice.presentation.viewholder.NoticeUiState

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