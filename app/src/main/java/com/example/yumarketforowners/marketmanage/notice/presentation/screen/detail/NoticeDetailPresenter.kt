package com.example.yumarketforowners.marketmanage.notice.presentation.screen.detail

import com.example.yumarketforowners.marketmanage.notice.domain.usecase.GetNoticeByIdUseCase
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class NoticeDetailPresenter(
    private val view: NoticeDetailView,
    private val getNoticeByIdUseCase: GetNoticeByIdUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun requestNoticeById(noticeId: Long) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            val result = getNoticeByIdUseCase(noticeId = noticeId)
            view.loading(isLoading = false)

            view.onRequestNoticeSuccess(notice = result)
        }
    }
}
