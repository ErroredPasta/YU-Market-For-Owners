package com.example.yumarketforowners.di.activity

import com.example.yumarketforowners.di.qualifier.LifeCycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScopeType
import com.example.yumarketforowners.domain.usecase.item.GetSingleItemUseCase
import com.example.yumarketforowners.domain.usecase.item.UpdateItemUseCase
import com.example.yumarketforowners.domain.usecase.market.GetMarketDetailUseCase
import com.example.yumarketforowners.domain.usecase.market.UpdateMarketUseCase
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.UpdateItemPresenter
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.UpdateItemView
import com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket.UpdateMarketPresenter
import com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket.UpdateMarketView
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
    fun provideEditMarketPresenter(
        view: UpdateMarketView,
        getMarketDetailUseCase: GetMarketDetailUseCase,
        updateMarketUseCase: UpdateMarketUseCase,
        @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = UpdateMarketPresenter(
        view = view,
        getMarketDetailUseCase = getMarketDetailUseCase,
        updateMarketUseCase = updateMarketUseCase,
        scopeProvider = scopeProvider,
    )

    /* TODO: 2022-10-27 목 04:11, fill parameters */
    @Provides
    fun provideUpdateItemPresenter(
        view: UpdateItemView,
        getSingleItemUseCase: GetSingleItemUseCase,
        updateItemUseCase: UpdateItemUseCase,
        @LifeCycleScope(LifeCycleScopeType.ACTIVITY) scopeProvider: Provider<CoroutineScope>
    ) = UpdateItemPresenter(
        view = view,
        getSingleItemUseCase = getSingleItemUseCase,
        updateItemUseCase = updateItemUseCase,
        scopeProvider = scopeProvider
    )
}