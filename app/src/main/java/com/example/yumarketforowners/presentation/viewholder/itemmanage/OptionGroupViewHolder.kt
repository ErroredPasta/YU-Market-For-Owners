package com.example.yumarketforowners.presentation.viewholder.itemmanage

import com.example.yumarketforowners.databinding.ViewHolderOptionGroupBinding
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.OptionGroupUiState
import com.example.yumarketforowners.presentation.screen.itemmanage.updateitem.OptionUiState
import com.example.yumarketforowners.presentation.viewholder.BaseViewHolder

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