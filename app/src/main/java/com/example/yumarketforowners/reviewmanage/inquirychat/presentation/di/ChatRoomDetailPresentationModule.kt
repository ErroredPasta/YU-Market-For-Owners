package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.di

import android.app.Activity
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.GetChatsByChatRoomIdUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.SendChatUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.chatroomdetail.ChatRoomDetailPresenter
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.chatroomdetail.ChatRoomDetailView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(ActivityComponent::class)
object ChatRoomDetailPresentationModule {

    @Provides
    fun provideChatRoomDetailView(activity: Activity) = activity as ChatRoomDetailView

    @Provides
    fun provideChatRoomDetailPresenter(
        view: ChatRoomDetailView,
        getChatsByChatRoomIdUseCase: GetChatsByChatRoomIdUseCase,
        sendChatUseCase: SendChatUseCase,
        @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = ChatRoomDetailPresenter(
        view = view,
        getChatsByChatRoomIdUseCase = getChatsByChatRoomIdUseCase,
        sendChatUseCase = sendChatUseCase,
        scopeProvider = scopeProvider
    )
}