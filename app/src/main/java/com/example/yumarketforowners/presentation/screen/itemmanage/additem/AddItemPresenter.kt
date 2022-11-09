package com.example.yumarketforowners.presentation.screen.itemmanage.additem

import com.example.yumarketforowners.domain.usecase.item.AddItemUseCase
import com.example.yumarketforowners.presentation.mapper.item.toItem
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.OptionGroupUiState
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.OptionUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Provider

class AddItemPresenter(
    private val view: AddItemView,
    private val addItemUseCase: AddItemUseCase,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    private var optionGroupUiStates = emptyList<OptionGroupUiState>()

    fun addItem(itemToAdd: AddItemUiState) {
        coroutineScope.launch {
            addItemUseCase(itemToAdd = itemToAdd.toItem(optionGroupUiStates))
            view.navigateBack()
        }
    }

    fun addOptionGroup() {
        optionGroupUiStates = optionGroupUiStates + createNewOptionGroupUiState()

        view.showOptionGroups(optionGroups = optionGroupUiStates)
    }

    fun cancelUpdateItem() {
        view.navigateBack()
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

data class AddItemUiState(
    val name: String,
    val description: String,
    val stock: Int,
    val price: Int,
    val discountedPrice: Int,
    val imageUrl: String?,
    val available: Boolean
)