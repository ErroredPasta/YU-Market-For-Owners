package com.example.yumarketforowners.presentation.screen.marketmanage.notice.detail

import com.example.yumarketforowners.domain.usecase.notice.GetNoticeByIdUseCase
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
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
