package com.example.yumarketforowners.reviewmanage.review.presentation.screen

import android.util.Log
import com.example.yumarketforowners.reviewmanage.review.domain.usecase.GetReviewsUseCase
import com.example.yumarketforowners.reviewmanage.review.presentation.mapper.toReviewUiState
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class ReviewManagePresenter(
    private val view: ReviewListView,
    private val getReviewsUseCase: GetReviewsUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun requestData(marketId: String) {
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