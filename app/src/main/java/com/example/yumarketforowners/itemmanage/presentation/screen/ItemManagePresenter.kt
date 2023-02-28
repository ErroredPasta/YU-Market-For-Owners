package com.example.yumarketforowners.itemmanage.presentation.screen

import com.example.yumarketforowners.itemmanage.domain.usecase.GetItemsUseCase
import com.example.yumarketforowners.itemmanage.presentation.mapper.toItemUiState
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import com.example.yumarketforowners.core.presentation.di.LifeCycleScope
import com.example.yumarketforowners.core.presentation.di.LifeCycleScopeType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject
import javax.inject.Provider

class ItemManagePresenter @Inject constructor(
    private val view: ItemManageView,
    private val getItemsUseCase: GetItemsUseCase,
    @LifeCycleScope(LifeCycleScopeType.FRAGMENT) scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    fun requestData(marketId: String, available: Boolean) {
        /* TODO: 2022-09-21 수 01:34, error 처리 구현 */
        getItemsUseCase(marketId = marketId, available = available)
            .onStart { view.loading(isLoading = true) }
            .onEach {
                val result = it.map { item ->
                    item.toItemUiState(
                        onEditItemButtonClick = { view.navigateToEditScreen(item) }
                    )
                }
                view.loading(isLoading = false)
                view.onRequestDataSuccess(result)
            }.catch { cause -> view.onError(cause) }
            .launchIn(coroutineScope)
    }
}