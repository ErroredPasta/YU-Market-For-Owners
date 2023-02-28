package com.example.yumarketforowners.marketmanage.notice.presentation.screen.detail

import com.example.yumarketforowners.marketmanage.notice.domain.usecase.GetNoticeByIdUseCase
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class NoticeDetailPresenter @Inject constructor(
    private val view: NoticeDetailView,
    private val getNoticeByIdUseCase: GetNoticeByIdUseCase,
    @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    fun requestNoticeById(noticeId: Long) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            val result = getNoticeByIdUseCase(noticeId = noticeId)
            view.loading(isLoading = false)

            view.onRequestNoticeSuccess(notice = result)
        }
    }
}
