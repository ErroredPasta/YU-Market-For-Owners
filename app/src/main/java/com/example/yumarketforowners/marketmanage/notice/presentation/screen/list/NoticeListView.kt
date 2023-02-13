package com.example.yumarketforowners.marketmanage.notice.presentation.screen.list

import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.marketmanage.notice.presentation.viewholder.NoticeUiState

interface NoticeListView : BaseView {
    fun onRequestNoticeListSuccess(notices: List<NoticeUiState>)
    fun navigateToNoticeDetailScreen(noticeId: Long)
}