package com.example.yumarketforowners.itemmanage.presentation.di

import android.app.Activity
import com.example.yumarketforowners.itemmanage.presentation.screen.additem.AddItemView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object AddItemPresentationModule {

    @Provides
    fun provideAddItemView(activity: Activity) = activity as AddItemView
}