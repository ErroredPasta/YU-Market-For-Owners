package com.example.yumarketforowners.itemmanage.presentation.di

import android.app.Activity
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.itemmanage.domain.usecase.GetSingleItemUseCase
import com.example.yumarketforowners.itemmanage.domain.usecase.UpdateItemUseCase
import com.example.yumarketforowners.itemmanage.presentation.screen.updateitem.UpdateItemPresenter
import com.example.yumarketforowners.itemmanage.presentation.screen.updateitem.UpdateItemView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(ActivityComponent::class)
object UpdateItemPresentationModule {

    @Provides
    fun provideUpdateItemView(activity: Activity) = activity as UpdateItemView

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