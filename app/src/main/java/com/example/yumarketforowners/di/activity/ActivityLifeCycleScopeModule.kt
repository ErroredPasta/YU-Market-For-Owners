package com.example.yumarketforowners.di.activity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScopeType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope

@Module
@InstallIn(ActivityComponent::class)
object ActivityLifeCycleScopeModule {
    @Provides
    @LifeCycleScope(LifeCycleScopeType.ACTIVITY)
    fun provideActivityLifeCycleScope(activity: Activity) =
        (activity as AppCompatActivity).lifecycleScope as CoroutineScope
}
