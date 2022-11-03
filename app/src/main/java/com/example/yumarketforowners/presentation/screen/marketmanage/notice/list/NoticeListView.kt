package com.example.yumarketforowners.presentation.screen.marketmanage.notice.list

import com.example.yumarketforowners.presentation.screen.base.BaseView

interface NoticeListView : BaseView {
    fun onRequestNoticeListSuccess(notices: List<NoticeUiState>)
    fun navigateToNoticeDetailScreen(noticeId: Long)
}