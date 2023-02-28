package com.example.yumarketforowners.auth.presentation.di

import android.app.Activity
import com.example.yumarketforowners.auth.presentation.screen.LoginView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
object LoginPresentationModule {

    @Provides
    fun provideLoginView(activity: Activity) = activity as LoginView
}