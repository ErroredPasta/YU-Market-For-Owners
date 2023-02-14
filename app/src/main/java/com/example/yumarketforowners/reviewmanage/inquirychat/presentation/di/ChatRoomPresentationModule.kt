package com.example.yumarketforowners.reviewmanage.inquirychat.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.GetChatRoomsUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.RemoveChatRoomUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.ChatRoomListPresenter
import com.example.yumarketforowners.reviewmanage.inquirychat.presentation.screen.ChatRoomListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object ChatRoomPresentationModule {

    @Provides
    fun provideChatRoomListView(fragment: Fragment) = fragment as ChatRoomListView

    @Provides
    fun provideChatRoomListPresenter(
        view: ChatRoomListView,
        getChatRoomsUseCase: GetChatRoomsUseCase,
        removeChatRoomUseCase: RemoveChatRoomUseCase,
        @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
    ) = ChatRoomListPresenter(
        view = view,
        getChatRoomsUseCase = getChatRoomsUseCase,
        removeChatRoomUseCase = removeChatRoomUseCase,
        scopeProvider = scopeProvider
    )
}