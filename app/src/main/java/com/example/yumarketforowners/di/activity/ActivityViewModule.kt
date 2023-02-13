package com.example.yumarketforowners.di.activity

import android.app.Activity
import com.example.yumarketforowners.core.presentation.base.BaseView
import com.example.yumarketforowners.itemmanage.presentation.screen.additem.AddItemView
import com.example.yumarketforowners.itemmanage.presentation.screen.updateitem.UpdateItemView
import com.example.yumarketforowners.auth.presentation.screen.LoginView
import com.example.yumarketforowners.marketmanage.profile.presentation.screen.UpdateProfileView
import com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket.UpdateMarketView
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.chatroomdetail.ChatRoomDetailView
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

    @Provides
    fun provideLoginView(activity: Activity) = activity as LoginView
}