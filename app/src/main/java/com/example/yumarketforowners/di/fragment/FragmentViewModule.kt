package com.example.yumarketforowners.di.fragment

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.itemmanage.presentation.screen.ItemManageView
import com.example.yumarketforowners.marketmanage.customersupport.presentation.screen.faq.FaqListView
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.detail.NoticeDetailView
import com.example.yumarketforowners.marketmanage.notice.presentation.screen.list.NoticeListView
import com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket.UpdateMarketView
import com.example.yumarketforowners.orderlist.presentation.screen.OrderListView
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.ChatRoomListView
import com.example.yumarketforowners.reviewmanage.review.presentation.screen.ReviewListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
@Suppress("UNCHECKED_CAST")
object FragmentViewModule {

    @Provides
    fun provideBaseView(fragment: Fragment) = fragment as BaseView

    @Provides
    fun provideReviewView(fragment: Fragment) = fragment as ReviewListView

    @Provides
    fun provideChatRoomView(fragment: Fragment) = fragment as ChatRoomListView

    @Provides
    fun provideOrderListView(fragment: Fragment) = fragment as OrderListView

    @Provides
    fun provideItemManageView(fragment: Fragment) = fragment as ItemManageView

    @Provides
    fun provideUpdateMarketView(fragment: Fragment) = fragment as UpdateMarketView

    @Provides
    fun provideNoticeListView(fragment: Fragment) = fragment as NoticeListView

    @Provides
    fun provideNoticeDetailView(fragment: Fragment) = fragment as NoticeDetailView

    @Provides
    fun provideCustomerSupportListView(fragment: Fragment) = fragment as FaqListView
}