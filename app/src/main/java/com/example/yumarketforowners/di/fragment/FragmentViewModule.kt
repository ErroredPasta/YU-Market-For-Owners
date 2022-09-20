package com.example.yumarketforowners.di.fragment

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.presentation.screen.itemmanage.ItemListInnerFragment
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListInnerFragment
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.ChatRoomInnerFragment
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.review.ReviewInnerFragment
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
        fragment as ReviewInnerFragment

    @Provides
    fun provideChatRoomView(fragment: Fragment) =
        fragment as ChatRoomInnerFragment

    @Provides
    fun provideOrderListView(fragment: Fragment) =
        fragment as OrderListInnerFragment

    @Provides
    fun provideItemManageView(fragment: Fragment) =
        fragment as ItemListInnerFragment
}