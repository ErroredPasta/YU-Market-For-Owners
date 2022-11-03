package com.example.yumarketforowners.presentation.screen.marketmanage.notice.list

import com.example.yumarketforowners.domain.model.notice.NoticePriority
import com.example.yumarketforowners.domain.usecase.notice.GetAllNoticesUseCase
import com.example.yumarketforowners.presentation.mapper.notice.toNoticeUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.viewholder.CellType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate
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

data class NoticeUiState(
    override val id: Long,
    val title: String,
    val content: String,
    val writtenAt: LocalDate,
    val priority: NoticePriority,
    val onNoticeClicked: () -> Unit
) : BaseViewHolderState(id, CellType.NOTICE_CELL)