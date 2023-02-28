package com.example.yumarketforowners.reviewmanage.review.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.reviewmanage.review.presentation.screen.ReviewListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ReviewPresentationModule {

    @Provides
    fun provideReviewListView(fragment: Fragment) = fragment as ReviewListView
}