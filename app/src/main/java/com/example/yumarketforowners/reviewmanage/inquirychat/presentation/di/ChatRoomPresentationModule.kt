package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.ChatRoomListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ChatRoomPresentationModule {

    @Provides
    fun provideChatRoomListView(fragment: Fragment) = fragment as ChatRoomListView
}