package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review

import com.example.yumarketforowners.R
import com.example.yumarketforowners.domain.model.order.Order
import com.example.yumarketforowners.domain.model.review.Reply
import com.example.yumarketforowners.domain.usecase.review.GetReviews
import com.example.yumarketforowners.presentation.mapper.review.toReviewUiState
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.screen.base.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ReviewManagePresenter @Inject constructor(
    private val view: ReviewListView,
    private val getReviews: GetReviews,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    fun requestData(marketId: Long) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            // TODO: 2022.06.04 get all data by market id
            /* TODO: 2022-09-21 수 01:35, error 처리 구현 */
            val result = getReviews(marketId = marketId)?.let {
                Result.Success(
                    data = it.map { review -> review.toReviewUiState() }
                )
            } ?: Result.Error(R.string.error_placeholder)

            view.loading(isLoading = false)

            when (result) {
                is Result.Success -> view.onRequestDataSuccess(result.data)
                is Result.Error -> view.onRequestDataError(result.errorMessage)
            }
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
    val reply: Reply? = null
) : BaseViewHolderState(id, CellType.REVIEW_CELL)
