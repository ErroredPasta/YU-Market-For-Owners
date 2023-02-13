package com.example.yumarketforowners.di.activity

import com.example.yumarketforowners.di.qualifier.LifeCycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScopeType.ACTIVITY
import com.example.yumarketforowners.auth.domain.usecase.GoogleLoginUseCase
import com.example.yumarketforowners.auth.domain.usecase.KakaoLoginUseCase
import com.example.yumarketforowners.auth.domain.usecase.LoginUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.GetChatsByChatRoomIdUseCase
import com.example.yumarketforowners.reviewmanage.inquirychat.domain.usecase.SendChatUseCase
import com.example.yumarketforowners.itemmanage.domain.usecase.AddItemUseCase
import com.example.yumarketforowners.itemmanage.domain.usecase.GetSingleItemUseCase
import com.example.yumarketforowners.itemmanage.domain.usecase.UpdateItemUseCase
import com.example.yumarketforowners.marketmanage.market.domain.usecase.GetMarketDetailUseCase
import com.example.yumarketforowners.marketmanage.market.domain.usecase.UpdateMarketUseCase
import com.example.yumarketforowners.auth.domain.usecase.GetCurrentUserUseCase
import com.example.yumarketforowners.auth.domain.usecase.UpdateUserUseCase
import com.example.yumarketforowners.itemmanage.presentation.screen.additem.AddItemPresenter
import com.example.yumarketforowners.itemmanage.presentation.screen.additem.AddItemView
import com.example.yumarketforowners.itemmanage.presentation.screen.updateitem.UpdateItemPresenter
import com.example.yumarketforowners.itemmanage.presentation.screen.updateitem.UpdateItemView
import com.example.yumarketforowners.auth.presentation.screen.LoginPresenter
import com.example.yumarketforowners.auth.presentation.screen.LoginView
import com.example.yumarketforowners.marketmanage.profile.presentation.screen.UpdateProfilePresenter
import com.example.yumarketforowners.marketmanage.profile.presentation.screen.UpdateProfileView
import com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket.UpdateMarketPresenter
import com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket.UpdateMarketView
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
        scopeProvider = scopeProvider
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

    @Provides
    fun provideLoginPresenter(
        view: LoginView,
        loginUseCase: LoginUseCase,
        kakaoLoginUseCase: KakaoLoginUseCase,
        googleLoginUseCase: GoogleLoginUseCase,
        @LifeCycleScope(ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = LoginPresenter(
        view = view,
        loginUseCase = loginUseCase,
        kakaoLoginUseCase = kakaoLoginUseCase,
        googleLoginUseCase = googleLoginUseCase,
        scopeProvider = scopeProvider
    )
}