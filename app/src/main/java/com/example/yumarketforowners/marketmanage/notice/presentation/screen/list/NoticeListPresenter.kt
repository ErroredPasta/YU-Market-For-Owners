package com.example.yumarketforowners.marketmanage.notice.presentation.screen.list

import com.example.yumarketforowners.marketmanage.notice.domain.usecase.GetAllNoticesUseCase
import com.example.yumarketforowners.marketmanage.notice.presentation.mapper.toNoticeUiState
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class NoticeListPresenter @Inject constructor(
    private val view: NoticeListView,
    private val getAllNoticesUseCase: GetAllNoticesUseCase,
    @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

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