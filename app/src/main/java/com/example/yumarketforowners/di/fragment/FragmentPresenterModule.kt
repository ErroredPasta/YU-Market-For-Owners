package com.example.yumarketforowners.di.fragment

import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import com.example.yumarketforowners.domain.model.reviewmanage.Review
import com.example.yumarketforowners.presentation.screen.itemmanage.ItemManageContract
import com.example.yumarketforowners.presentation.screen.itemmanage.ItemManagePresenter
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListContract
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListPresenter
import com.example.yumarketforowners.presentation.screen.reviewmanage.ReviewManageContract
import com.example.yumarketforowners.presentation.screen.reviewmanage.ReviewManagePresenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class FragmentPresenterModule {
    @Binds
    abstract fun bindItemManagePresenter(presenter: ItemManagePresenter): ItemManageContract.Presenter

    @Binds
    abstract fun bindOrderListPresenter(presenter: OrderListPresenter): OrderListContract.Presenter

    @Binds
    abstract fun bindReviewPresenter(presenter: ReviewManagePresenter<Review>):
            ReviewManageContract.Presenter<Review>

    @Binds
    abstract fun bindChatRoomPresenter(presenter: ReviewManagePresenter<ChatRoom>):
            ReviewManageContract.Presenter<ChatRoom>
}