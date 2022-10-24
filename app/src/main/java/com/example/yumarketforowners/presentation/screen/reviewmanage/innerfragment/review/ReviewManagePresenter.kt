package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review

import android.util.Log
import com.example.yumarketforowners.domain.model.order.Order
import com.example.yumarketforowners.domain.model.review.Reply
import com.example.yumarketforowners.domain.usecase.review.GetReviewsUseCase
import com.example.yumarketforowners.presentation.mapper.review.toReviewUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.viewholder.CellType
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class ReviewManagePresenter(
    private val view: ReviewListView,
    private val getReviewsUseCase: GetReviewsUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun requestData(marketId: Long) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            // TODO: 2022.06.04 get all data by market id
            /* TODO: 2022-09-21 수 01:35, error 처리 구현 */
            val result = getReviewsUseCase(marketId = marketId).map { review ->
                review.toReviewUiState(
                    onReplyClicked = {
                        Log.d("TAG", "onReplyClicked: ${review.id}")
                    }
                )
            }

            view.loading(isLoading = false)

            view.onRequestDataSuccess(result)
        }
    }
}

data class ReviewUiState(
    override val id: Long,
    val writerName: String,
    val profileImageUrl: String?,
    val writtenAt: Long,
    val order: Order,
    val title: String?,
    val content: String,
    val rating: Int,
    val reviewImages: List<String>,
    val reply: Reply? = null,
    val onReplyClicked: () -> Unit
) : BaseViewHolderState(id, CellType.REVIEW_CELL)
