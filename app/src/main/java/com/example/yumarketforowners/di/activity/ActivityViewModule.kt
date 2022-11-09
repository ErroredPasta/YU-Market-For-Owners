package com.example.yumarketforowners.di.activity

import android.app.Activity
import com.example.yumarketforowners.presentation.screen.base.BaseView
import com.example.yumarketforowners.presentation.screen.itemmanage.additem.AddItemView
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.UpdateItemView
import com.example.yumarketforowners.presentation.screen.marketmanage.profile.UpdateProfileView
import com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket.UpdateMarketView
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.chatroomdetail.ChatRoomDetailView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ActivityViewModule {

    @Provides
    fun provideBaseView(activity: Activity) = activity as BaseView

    @Provides
    fun provideUpdateMarketView(activity: Activity) = activity as UpdateMarketView

    @Provides
    fun provideUpdateItemView(activity: Activity) = activity as UpdateItemView

    @Provides
    fun provideUpdateProfileView(activity: Activity) = activity as UpdateProfileView

    @Provides
    fun provideChatRoomDetailView(activity: Activity) = activity as ChatRoomDetailView

    @Provides
    fun provideAddItemView(activity: Activity) = activity as AddItemView
}