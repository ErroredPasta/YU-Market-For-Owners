package com.example.yumarketforowners.core.presentation.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import com.example.yumarketforowners.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object NavigationModule {

    @Provides
    @ActivityScoped
    fun provideNavController(activity: Activity) =
        ((activity as AppCompatActivity).supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHost).navController
}