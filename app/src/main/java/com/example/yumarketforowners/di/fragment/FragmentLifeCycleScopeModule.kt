package com.example.yumarketforowners.di.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope

@Module
@InstallIn(FragmentComponent::class)
object FragmentLifeCycleScopeModule {
    @Provides
    fun provideViewLifeCycleScope(fragment: Fragment) =
        fragment.viewLifecycleOwner.lifecycleScope as CoroutineScope
}