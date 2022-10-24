package com.example.yumarketforowners.di.fragment

import com.example.yumarketforowners.di.qualifier.LifeCycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScopeType.FRAGMENT
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatRoomsUseCase
import com.example.yumarketforowners.domain.usecase.item.GetItemsUseCase
import com.example.yumarketforowners.domain.usecase.order.UpdateOrderStateUseCase
import com.example.yumarketforowners.domain.usecase.review.GetReviewsUseCase
import com.example.yumarketforowners.presentation.screen.itemmanage.ItemManagePresenter
import com.example.yumarketforowners.presentation.screen.itemmanage.ItemManageView
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListPresenter
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListView
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.ChatRoomListPresenter
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.ChatRoomListView
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review.ReviewListView
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review.ReviewManagePresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object FragmentPresenterModule {

    @Provides
    fun provideOrderListPresenter(
        view: OrderListView,
        updateOrderStateUseCase: UpdateOrderStateUseCase,
        @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>,
        repository: OrderRepository
    ) = OrderListPresenter(
        view = view,
        updateOrderStateUseCase = updateOrderStateUseCase,
        orderListFlow = repository.orderListFlow,
        scopeProvider = scopeProvider,
    )

    @Provides
    fun provideItemManagePresenter(
        view: ItemManageView,
        getItemsUseCase: GetItemsUseCase,
        @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = ItemManagePresenter(
        view = view,
        getItemsUseCase = getItemsUseCase,
        scopeProvider = scopeProvider
    )

    @Provides
    fun provideChatRoomListPresenter(
        view: ChatRoomListView,
        getChatRoomsUseCase: GetChatRoomsUseCase,
        @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = ChatRoomListPresenter(
        view = view,
        getChatRoomsUseCase = getChatRoomsUseCase,
        scopeProvider = scopeProvider
    )

    @Provides
    fun provideReviewManagePresenter(
        view: ReviewListView,
        getReviewsUseCase: GetReviewsUseCase,
        @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = ReviewManagePresenter(
        view = view,
        getReviewsUseCase = getReviewsUseCase,
        scopeProvider = scopeProvider
    )
}