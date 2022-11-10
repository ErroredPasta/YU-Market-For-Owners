package com.example.yumarketforowners.presentation.screen.itemmanage.updateitem

import com.example.yumarketforowners.domain.usecase.item.GetSingleItemUseCase
import com.example.yumarketforowners.domain.usecase.item.UpdateItemUseCase
import com.example.yumarketforowners.presentation.mapper.item.toItem
import com.example.yumarketforowners.presentation.mapper.item.toOptionGroupUiStates
import com.example.yumarketforowners.presentation.mapper.item.toUpdateItemUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.viewholder.itemmanage.OptionGroupUiState
import com.example.yumarketforowners.presentation.viewholder.itemmanage.OptionUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class UpdateItemPresenter(
    private val view: UpdateItemView,
    private val getSingleItemUseCase: GetSingleItemUseCase,
    private val updateItemUseCase: UpdateItemUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    private var optionGroupUiStates = emptyList<OptionGroupUiState>()

    fun requestItem(itemId: Long) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            val result = getSingleItemUseCase(itemId = itemId).also {
                optionGroupUiStates = it.optionGroups.toOptionGroupUiStates(
                    onDeleteOptionGroupButtonClicked = { removeOptionGroupUiState() },
                    onAddOptionButtonClicked = { addNewOptionUiStateToList() },
                    onDeleteOptionButtonClicked = { removeFromOptionGroupUiState() }
                )
            }.toUpdateItemUiState()
            view.loading(isLoading = false)

            view.onRequestItemSuccess(item = result)
            view.showOptionGroups(optionGroups = optionGroupUiStates)
        }
    }

    fun cancelUpdateItem() {
        view.navigateBack()
    }

    fun addOptionGroup() {
        optionGroupUiStates = optionGroupUiStates + createNewOptionGroupUiState()

        view.showOptionGroups(optionGroups = optionGroupUiStates)
    }

    fun updateItem(updateItemUiState: UpdateItemUiState) {
        coroutineScope.launch {
            updateItemUseCase(updatedItem = updateItemUiState.toItem(optionGroupUiStates))
            view.navigateBack()
        }
    }

    private fun createNewOptionUiState(
        id: Long,
        optionGroupUiState: OptionGroupUiState
    ) = OptionUiState(
        id = id,
        name = "",
        additionalPrice = 0,
        optionGroupUiState = optionGroupUiState,
        onDeleteOptionButtonClicked = { removeFromOptionGroupUiState() }
    )

    private fun createNewOptionGroupUiState() = OptionGroupUiState(
        id = -(optionGroupUiStates.size.toLong() + 1),
        onDeleteOptionGroupButtonClicked = { removeOptionGroupUiState() },
        onAddOptionButtonClicked = { addNewOptionUiStateToList() }
    ).apply {
        optionUiStates = listOf(
            createNewOptionUiState(
                id = -1L,
                optionGroupUiState = this
            )
        )
    }

    private fun OptionGroupUiState.addNewOptionUiStateToList() {
        optionUiStates += createNewOptionUiState(
            id = -(optionUiStates.size + 1L),
            optionGroupUiState = this
        )
    }

    private fun OptionUiState.removeFromOptionGroupUiState() {
        optionGroupUiState.optionUiStates -= this
        optionGroupUiState.updateOptionUiStates()
    }

    private fun OptionGroupUiState.removeOptionGroupUiState() {
        optionGroupUiStates = optionGroupUiStates - this
        view.showOptionGroups(optionGroups = optionGroupUiStates)
    }
}

data class UpdateItemUiState(
    val id: Long,
    var name: String,
    var description: String,
    var stock: Int,
    var price: Int,
    var discountedPrice: Int,
    var imageUrl: String?,
    var available: Boolean
)