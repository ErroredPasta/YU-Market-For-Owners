package com.example.yumarketforowners.di.fragment

import com.example.yumarketforowners.di.qualifier.LifeCycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScopeType.FRAGMENT
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.domain.usecase.order.UpdateOrderState
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListPresenter
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object FragmentPresenterModule {
    @Provides
    fun provideOrderListPresenter(
        view: OrderListView,
        updateOrderState: UpdateOrderState,
        @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>,
        repository: OrderRepository
    ) = OrderListPresenter(
        view = view,
        updateOrderState = updateOrderState,
        scopeProvider = scopeProvider,
        orderListFlow = repository.orderListFlow
    )
}