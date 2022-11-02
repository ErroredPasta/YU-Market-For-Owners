package com.example.yumarketforowners.presentation.screen.itemmanage

import com.example.yumarketforowners.domain.model.item.OptionGroup
import com.example.yumarketforowners.domain.usecase.item.GetItemsUseCase
import com.example.yumarketforowners.presentation.mapper.item.toItemUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.viewholder.CellType
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

    fun requestData(marketId: Long, available: Boolean) {
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

data class ItemUiState(
    override val id: Long,
    val name: String,
    val description: String,
    val stock: Int,
    val price: Int,
    val discountedPrice: Int,
    val discountRatio: Int,
    val imageUrl: String?,
    val optionGroups: List<OptionGroup>,
    val available: Boolean,
    var checkedForStateChange: Boolean = false,
    val onEditItemButtonClick: () -> Unit
) : BaseViewHolderState(id, CellType.ITEM_CELL)
