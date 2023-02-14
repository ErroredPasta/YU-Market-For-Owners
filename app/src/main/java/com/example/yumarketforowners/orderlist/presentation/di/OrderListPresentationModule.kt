package com.example.yumarketforowners.orderlist.presentation.di

import androidx.fragment.app.Fragment
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import com.example.yumarketforowners.orderlist.domain.repository.OrderRepository
import com.example.yumarketforowners.orderlist.domain.usecase.UpdateOrderStateUseCase
import com.example.yumarketforowners.orderlist.presentation.screen.OrderListPresenter
import com.example.yumarketforowners.orderlist.presentation.screen.OrderListView
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Provider

@Module
@InstallIn(FragmentComponent::class)
object OrderListPresentationModule {

    @Provides
    fun provideOrderListView(fragment: Fragment) = fragment as OrderListView

    @Provides
    fun provideOrderListPresenter(
        view: OrderListView,
        updateOrderStateUseCase: UpdateOrderStateUseCase,
        @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>,
        repository: OrderRepository
    ) = OrderListPresenter(
        view = view,
        updateOrderStateUseCase = updateOrderStateUseCase,
        orderListFlow = repository.orderListFlow,
        scopeProvider = scopeProvider,
    )
}