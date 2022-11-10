package com.example.yumarketforowners.presentation.viewholder.itemmanage

import com.example.yumarketforowners.databinding.ViewHolderOptionGroupBinding
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.viewholder.CellType

class OptionGroupViewHolder(
    binding: ViewHolderOptionGroupBinding
) : BaseViewHolder<ViewHolderOptionGroupBinding, OptionGroupUiState>(binding) {

    private val adapter = ModelRecyclerAdapter<OptionUiState>()

    override fun bindData(model: OptionGroupUiState) = with(binding) {
        super.bindData(model)
        optionGroupUiState = model.apply {
            updateOptionUiStates = { adapter.submitList(optionGroupUiState!!.optionUiStates) }
        }
        optionRecyclerView.adapter = adapter.also { it.submitList(model.optionUiStates) }

        addOptionButton.setOnClickListener {
            model.onAddOptionButtonClicked(optionGroupUiState!!)
            adapter.submitList(optionGroupUiState!!.optionUiStates)
        }
    }
}

data class OptionGroupUiState(
    override val id: Long,
    var name: String = "",
    var optionUiStates: List<OptionUiState> = emptyList(),
    var minSelect: Int = 0,
    var maxSelect: Int = 1,
    val onDeleteOptionGroupButtonClicked: OptionGroupUiState.() -> Unit,
    val onAddOptionButtonClicked: OptionGroupUiState.() -> Unit,
    var updateOptionUiStates: () -> Unit = {}
) : BaseViewHolderState(id, CellType.OPTION_GROUP_CELL)