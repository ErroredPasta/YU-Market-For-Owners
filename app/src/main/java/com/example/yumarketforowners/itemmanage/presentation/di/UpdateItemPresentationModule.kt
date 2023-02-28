package com.example.yumarketforowners.itemmanage.presentation.di

import android.app.Activity
import com.example.yumarketforowners.itemmanage.presentation.screen.updateitem.UpdateItemView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UpdateItemPresentationModule {

    @Provides
    fun provideUpdateItemView(activity: Activity) = activity as UpdateItemView
}