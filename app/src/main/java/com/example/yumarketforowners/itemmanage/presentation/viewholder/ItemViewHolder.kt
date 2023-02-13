package com.example.yumarketforowners.itemmanage.presentation.viewholder

import com.example.yumarketforowners.databinding.ViewHolderItemBinding
import com.example.yumarketforowners.itemmanage.domain.model.OptionGroup
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType

class ItemViewHolder(
    binding: ViewHolderItemBinding
) : BaseViewHolder<ViewHolderItemBinding, ItemUiState>(binding) {
    override fun clear() {
        // TODO: 2022.05.30 clear image view
    }

    override fun bindData(model: ItemUiState) {
        super.bindData(model)
        binding.itemUiState = model
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