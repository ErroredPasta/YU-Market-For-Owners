package com.example.yumarketforowners.presentation.screen.marketmanage.notice.list

import com.example.yumarketforowners.presentation.screen.base.BaseView
import com.example.yumarketforowners.presentation.viewholder.notice.NoticeUiState

interface NoticeListView : BaseView {
    fun onRequestNoticeListSuccess(notices: List<NoticeUiState>)
    fun navigateToNoticeDetailScreen(noticeId: Long)
}