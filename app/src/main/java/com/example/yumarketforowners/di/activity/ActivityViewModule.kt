package com.example.yumarketforowners.di.activity

import android.app.Activity
import com.example.yumarketforowners.presentation.screen.marketmanage.updatemarket.UpdateMarketView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ActivityViewModule {
    @Provides
    fun provideUpdateMarketView(activity: Activity) = activity as UpdateMarketView
}