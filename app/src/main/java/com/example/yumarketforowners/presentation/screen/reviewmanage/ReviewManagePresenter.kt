package com.example.yumarketforowners.presentation.screen.reviewmanage

import com.example.yumarketforowners.domain.model.BaseModel
import com.example.yumarketforowners.domain.repository.ReviewOrChatRoomRepository
import javax.inject.Inject

class ReviewManagePresenter<M : BaseModel> @Inject constructor(
    private val view: ReviewManageContract.View<M>,
    private val repository: ReviewOrChatRoomRepository<M>
) : ReviewManageContract.Presenter<M> {

    @Suppress("UNCHECKED_CAST")
    override fun requestData(marketId: Long) {
        view.loading(show = true)
        // TODO: 2022.06.04 get all data by market id
        /* TODO: 2022-09-21 수 01:35, error 처리 구현 */
        val result: ReviewManageContract.State = ReviewManageContract.State.Success(
            data = repository.getAllByMarketId(marketId)
        )
        view.loading(show = false)

        if (result is ReviewManageContract.State.Success<*>) {
            view.onRequestDataSuccess((result as ReviewManageContract.State.Success<M>).data)
        } else {
            view.onRequestDataError((result as ReviewManageContract.State.Error).errorString)
        }
    }
}