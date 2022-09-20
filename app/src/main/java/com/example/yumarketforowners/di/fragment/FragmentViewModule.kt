package com.example.yumarketforowners.di.fragment

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.domain.model.reviewmanage.ChatRoom
import com.example.yumarketforowners.domain.model.reviewmanage.Review
import com.example.yumarketforowners.presentation.screen.itemmanage.ItemManageContract
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListContract
import com.example.yumarketforowners.presentation.screen.reviewmanage.ReviewManageContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
@Suppress("UNCHECKED_CAST")
object FragmentViewModule {
    @Provides
    fun provideReviewView(fragment: Fragment) =
        fragment as ReviewManageContract.View<Review>

    @Provides
    fun provideChatRoomView(fragment: Fragment) =
        fragment as ReviewManageContract.View<ChatRoom>

    @Provides
    fun provideOrderListView(fragment: Fragment) =
        fragment as OrderListContract.View

    @Provides
    fun provideItemManageView(fragment: Fragment) =
        fragment as ItemManageContract.View
}