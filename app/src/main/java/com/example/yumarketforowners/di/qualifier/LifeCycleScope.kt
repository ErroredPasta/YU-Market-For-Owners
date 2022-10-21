package com.example.yumarketforowners.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LifeCycleScope(val type: LifeCycleScopeType)

enum class LifeCycleScopeType {
    ACTIVITY, FRAGMENT
}
