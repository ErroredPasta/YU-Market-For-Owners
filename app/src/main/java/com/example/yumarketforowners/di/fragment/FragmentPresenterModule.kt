package com.example.yumarketforowners.di.fragment

import com.example.yumarketforowners.di.qualifier.LifeCycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScopeType.FRAGMENT
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import com.example.yumarketforowners.marketmanage.customersupport.domain.repository.CustomerSupportRepository
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.GetChatRoomsUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.RemoveChatRoomUseCase
import com.example.yumarketforowners.itemmanage.domain.usecase.GetItemsUseCase
import com.example.yumarketforowners.marketmanage.notice.domain.usecase.GetAllNoticesUseCase
import com.example.yumarketforowners.marketmanage.notice.domain.usecase.GetNoticeByIdUseCase
import com.example.yumarketforowners.orderlist.domain.usecase.UpdateOrderStateUseCase
import com.example.yumarketforowners.reviewmanage.review.domain.usecase.GetReviewsUseCase
import com.example.yumarketforowners.itemmanage.presentation.screen.ItemManagePresenter
import com.example.yumarketforowners.itemmanage.presentation.screen.ItemManageView
import com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq.FaqListPresenter
import com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq.FaqListView
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.detail.NoticeDetailPresenter
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.detail.NoticeDetailView
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.list.NoticeListPresenter
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.list.NoticeListView
import com.example.yumarketforowners.orderlist.presentation.screen.OrderListPresenter
import com.example.yumarketforowners.orderlist.presentation.screen.OrderListView
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.ChatRoomListPresenter
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.ChatRoomListView
import com.example.yumarketforowners.reviewmanage.review.presentation.screen.ReviewListView
import com.example.yumarketforowners.reviewmanage.review.presentation.screen.ReviewManagePresenter
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
        removeChatRoomUseCase: RemoveChatRoomUseCase,
        @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = ChatRoomListPresenter(
        view = view,
        getChatRoomsUseCase = getChatRoomsUseCase,
        removeChatRoomUseCase = removeChatRoomUseCase,
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

    @Provides
    fun provideNoticeListPresenter(
        view: NoticeListView,
        getAllNoticesUseCase: GetAllNoticesUseCase,
        @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = NoticeListPresenter(
        view = view,
        getAllNoticesUseCase = getAllNoticesUseCase,
        scopeProvider = scopeProvider
    )

    @Provides
    fun provideNoticeDetailPresenter(
        view: NoticeDetailView,
        getNoticeByIdUseCase: GetNoticeByIdUseCase,
        @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = NoticeDetailPresenter(
        view = view,
        getNoticeByIdUseCase = getNoticeByIdUseCase,
        scopeProvider = scopeProvider
    )

    @Provides
    fun provideCustomerSupportListPresenter(
        view: FaqListView,
        repository: CustomerSupportRepository,
        @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = FaqListPresenter(
        view = view,
        repository = repository,
        scopeProvider = scopeProvider
    )
}