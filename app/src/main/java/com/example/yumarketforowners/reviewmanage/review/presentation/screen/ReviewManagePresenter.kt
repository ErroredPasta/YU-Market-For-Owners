package com.example.yumarketforowners.reviewmanage.review.presentation.screen

import android.util.Log
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.core.util.runCoroutineCatching
import com.example.yumarketforowners.reviewmanage.review.domain.usecase.GetReviewsUseCase
import com.example.yumarketforowners.reviewmanage.review.presentation.mapper.toReviewUiState
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ReviewManagePresenter @Inject constructor(
    private val view: ReviewListView,
    private val getReviewsUseCase: GetReviewsUseCase,
    @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    fun requestData(marketId: String) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            // TODO: 2022.06.04 get all data by market id
            /* TODO: 2022-09-21 수 01:35, error 처리 구현 */
            runCoroutineCatching {
                getReviewsUseCase(marketId = marketId).map { review ->
                    review.toReviewUiState(
                        onReplyClicked = {
                            Log.d("TAG", "onReplyClicked: ${review.id}")
                        }
                    )
                }
            }.onSuccess { result ->
                view.onRequestDataSuccess(result)
            }.onFailure { cause ->
                view.onError(cause)
            }

            view.loading(isLoading = false)

        }
    }
}