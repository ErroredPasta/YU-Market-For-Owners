package com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review

import com.example.yumarketforowners.domain.model.reviewmanage.Review
import com.example.yumarketforowners.domain.usecase.review.GetReviews
import com.example.yumarketforowners.presentation.screen.base.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ReviewManagePresenter @Inject constructor(
    private val view: ReviewInnerFragment,
    private val getReviews: GetReviews,
    private val scopeProvider: Provider<CoroutineScope>
) {
    private val coroutineScope get() = scopeProvider.get()

    fun requestData(marketId: Long) {
        coroutineScope.launch {
            view.loading(show = true)
            // TODO: 2022.06.04 get all data by market id
            /* TODO: 2022-09-21 수 01:35, error 처리 구현 */
            val result: State = State.Success(
                data = getReviews(marketId = marketId)
            )
            view.loading(show = false)

            @Suppress("UNCHECKED_CAST")
            when (result) {
                is State.Success<*> -> view.onRequestDataSuccess(result.data as List<Review>)
                is State.Error -> view.onRequestDataError(result.errorMessage)
            }
        }
    }
}