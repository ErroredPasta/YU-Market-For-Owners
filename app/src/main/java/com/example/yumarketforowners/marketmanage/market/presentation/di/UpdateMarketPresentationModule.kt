package com.example.yumarketforowners.marketmanage.market.presentation.di

import android.app.Activity
import com.example.yumarketforowners.marketmanage.market.presentation.screen.updatemarket.UpdateMarketView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UpdateMarketPresentationModule {

    @Provides
    fun provideUpdateMarketView(activity: Activity) = activity as UpdateMarketView
}