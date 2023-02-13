package com.example.yumarketforowners.core.presentation.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState

abstract class BaseViewHolder<VDB : ViewDataBinding, M : BaseViewHolderState>(
    protected val binding: VDB
) : RecyclerView.ViewHolder(binding.root) {

    open fun clear() = Unit
    open fun bindData(model: M) {
        clear()
    }
}