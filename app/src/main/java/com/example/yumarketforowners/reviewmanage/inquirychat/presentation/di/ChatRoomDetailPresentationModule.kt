package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.di

import android.app.Activity
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.chatroomdetail.ChatRoomDetailView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ChatRoomDetailPresentationModule {

    @Provides
    fun provideChatRoomDetailView(activity: Activity) = activity as ChatRoomDetailView
}