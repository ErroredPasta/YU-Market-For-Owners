package com.example.yumarketforowners.core.presentation.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object ActivityLifeCycleScopeModule {

    @Provides
    @LifeCycleScope(LifeCycleScopeType.ACTIVITY)
    fun provideActivityLifeCycleScope(activity: Activity) =
        (activity as AppCompatActivity).lifecycleScope as CoroutineScope
}

@Module
@InstallIn(FragmentComponent::class)
object FragmentLifeCycleScopeModule {

    @Provides
    @LifeCycleScope(LifeCycleScopeType.FRAGMENT)
    fun provideViewLifeCycleScope(fragment: Fragment) =
        fragment.viewLifecycleOwner.lifecycleScope as CoroutineScope
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LifeCycleScope(val type: LifeCycleScopeType)

enum class LifeCycleScopeType {
    ACTIVITY, FRAGMENT
}