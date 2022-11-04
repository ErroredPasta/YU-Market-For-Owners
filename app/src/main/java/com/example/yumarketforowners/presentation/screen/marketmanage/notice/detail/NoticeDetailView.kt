package com.example.yumarketforowners.presentation.screen.marketmanage.notice.detail

import com.example.yumarketforowners.domain.model.notice.Notice
import com.example.yumarketforowners.presentation.screen.base.BaseView

interface NoticeDetailView : BaseView {
    fun onRequestNoticeSuccess(notice: Notice)
}