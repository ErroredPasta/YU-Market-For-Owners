package com.example.yumarketforowners.marketmanage.notice.presentation.screen.detail

import com.example.yumarketforowners.marketmanage.notice.domain.model.Notice
import com.example.yumarketforowners.core.presentation.base.BaseView

interface NoticeDetailView : BaseView {
    fun onRequestNoticeSuccess(notice: Notice)
}