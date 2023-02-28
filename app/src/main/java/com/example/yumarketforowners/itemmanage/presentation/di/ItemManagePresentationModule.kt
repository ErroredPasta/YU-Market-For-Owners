package com.example.yumarketforowners.itemmanage.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.itemmanage.presentation.screen.ItemManageView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ItemManagePresentationModule {

    @Provides
    fun provideItemManageView(fragment: Fragment) = fragment as ItemManageView
}