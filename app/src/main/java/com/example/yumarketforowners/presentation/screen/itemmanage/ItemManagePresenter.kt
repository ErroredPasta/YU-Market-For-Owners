package com.example.yumarketforowners.presentation.screen.itemmanage

import com.example.yumarketforowners.R
import com.example.yumarketforowners.domain.model.item.OptionGroup
import com.example.yumarketforowners.domain.usecase.item.GetItemsUseCase
import com.example.yumarketforowners.presentation.mapper.item.toItemUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.screen.base.Result
import com.example.yumarketforowners.presentation.viewholder.CellType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class ItemManagePresenter(
    private val view: ItemManageView,
    private val getItemsUseCase: GetItemsUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    fun requestData(marketId: Long, available: Boolean) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            // TODO: 2022.05.27 get item by market id
            /* TODO: 2022-09-21 수 01:34, error 처리 구현 */

            val result = getItemsUseCase(marketId = marketId, available = available)?.let {
                Result.Success(data = it.map { item ->
                    item.toItemUiState(
                        onEditItemButtonClick = { view.navigateToEditScreen(item) }
                    )
                })
            } ?: Result.Error(R.string.error_placeholder)

            view.loading(isLoading = false)

            when (result) {
                is Result.Success -> view.onRequestDataSuccess(result.data)
                is Result.Error -> view.onRequestDataError(result.errorMessage)
            }
        }
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
