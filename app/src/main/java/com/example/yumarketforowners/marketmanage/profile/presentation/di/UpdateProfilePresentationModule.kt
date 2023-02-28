package com.example.yumarketforowners.marketmanage.profile.presentation.di

import android.app.Activity
import com.example.yumarketforowners.marketmanage.profile.presentation.screen.UpdateProfileView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UpdateProfilePresentationModule {

    @Provides
    fun provideUpdateProfileView(activity: Activity) = activity as UpdateProfileView
}