package com.example.yumarketforowners.presentation.screen.marketmanage.notice.list

import com.example.yumarketforowners.domain.usecase.notice.GetAllNoticesUseCase
import com.example.yumarketforowners.presentation.mapper.notice.toNoticeUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class NoticeListPresenter(
    private val view: NoticeListView,
    private val getAllNoticesUseCase: GetAllNoticesUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun requestNotices() {
        coroutineScope.launch {
            view.loading(isLoading = true)
            val result = getAllNoticesUseCase().map {
                it.toNoticeUiState(
                    onNoticeClicked = { view.navigateToNoticeDetailScreen(noticeId = it.id) }
                )
            }
            view.loading(isLoading = false)

            view.onRequestNoticeListSuccess(notices = result)
        }
    }
}