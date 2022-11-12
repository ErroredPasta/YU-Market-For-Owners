package com.example.yumarketforowners.presentation.screen.itemmanage

import com.example.yumarketforowners.domain.usecase.item.GetItemsUseCase
import com.example.yumarketforowners.presentation.mapper.item.toItemUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Provider

class ItemManagePresenter(
    private val view: ItemManageView,
    private val getItemsUseCase: GetItemsUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

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