package com.example.yumarketforowners.di.activity

import com.example.yumarketforowners.di.qualifier.LifeCycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScopeType.*
import com.example.yumarketforowners.domain.usecase.chatroom.GetChatsByChatRoomIdUseCase
import com.example.yumarketforowners.domain.usecase.chatroom.SendChatUseCase
import com.example.yumarketforowners.domain.usecase.item.AddItemUseCase
import com.example.yumarketforowners.domain.usecase.item.GetSingleItemUseCase
import com.example.yumarketforowners.domain.usecase.item.UpdateItemUseCase
import com.example.yumarketforowners.domain.usecase.market.GetMarketDetailUseCase
import com.example.yumarketforowners.domain.usecase.market.UpdateMarketUseCase
import com.example.yumarketforowners.domain.usecase.user.GetCurrentUserUseCase
import com.example.yumarketforowners.domain.usecase.user.UpdateUserUseCase
import com.example.yumarketforowners.presentation.screen.itemmanage.additem.AddItemPresenter
import com.example.yumarketforowners.presentation.screen.itemmanage.additem.AddItemView
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.UpdateItemPresenter
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.UpdateItemView
import com.example.yumarketforowners.presentation.screen.marketmanage.profile.UpdateProfilePresenter
import com.example.yumarketforowners.presentation.screen.marketmanage.profile.UpdateProfileView
import com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket.UpdateMarketPresenter
import com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket.UpdateMarketView
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.chatroomdetail.ChatRoomDetailPresenter
import com.example.yumarketforowners.presentation.screen.reviewmanage.innerfragment.chatroom.chatroomdetail.ChatRoomDetailView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(ActivityComponent::class)
object ActivityPresenterModule {

    @Provides
    fun provideUpdateMarketPresenter(
        view: UpdateMarketView,
        getMarketDetailUseCase: GetMarketDetailUseCase,
        updateMarketUseCase: UpdateMarketUseCase,
        @LifeCycleScope(ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = UpdateMarketPresenter(
        view = view,
        getMarketDetailUseCase = getMarketDetailUseCase,
        updateMarketUseCase = updateMarketUseCase,
        scopeProvider = scopeProvider,
    )

    @Provides
    fun provideUpdateItemPresenter(
        view: UpdateItemView,
        getSingleItemUseCase: GetSingleItemUseCase,
        updateItemUseCase: UpdateItemUseCase,
        @LifeCycleScope(ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = UpdateItemPresenter(
        view = view,
        getSingleItemUseCase = getSingleItemUseCase,
        updateItemUseCase = updateItemUseCase,
        scopeProvider = scopeProvider
    )

    @Provides
    fun provideUpdateProfilePresenter(
        view: UpdateProfileView,
        getCurrentUserUseCase: GetCurrentUserUseCase,
        updateUserUseCase: UpdateUserUseCase,
        @LifeCycleScope(ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = UpdateProfilePresenter(
        view = view,
        getCurrentUserUseCase = getCurrentUserUseCase,
        updateUserUseCase = updateUserUseCase,
        scopeProvider = scopeProvider
    )

    @Provides
    fun provideChatRoomDetailPresenter(
        view: ChatRoomDetailView,
        getChatsByChatRoomIdUseCase: GetChatsByChatRoomIdUseCase,
        sendChatUseCase: SendChatUseCase,
        @LifeCycleScope(ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = ChatRoomDetailPresenter(
        view = view,
        getChatsByChatRoomIdUseCase = getChatsByChatRoomIdUseCase,
        sendChatUseCase = sendChatUseCase,
        scopeProvider = scopeProvider
    )

    @Provides
    fun provideAddItemPresenter(
        view: AddItemView,
        addItemUseCase: AddItemUseCase,
        @LifeCycleScope(ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = AddItemPresenter(
        view = view,
        addItemUseCase = addItemUseCase,
        scopeProvider = scopeProvider
    )
}