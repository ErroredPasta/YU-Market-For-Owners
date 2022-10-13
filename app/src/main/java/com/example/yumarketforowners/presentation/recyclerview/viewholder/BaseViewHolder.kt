package com.example.yumarketforowners.presentation.recyclerview.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState

abstract class BaseViewHolder<VDB : ViewDataBinding, M : BaseViewHolderState>(
    protected val binding: VDB
) : RecyclerView.ViewHolder(binding.root) {

    open fun clear() = Unit
    open fun bindData(model: M) {
        clear()
    }

    open fun bindListener(listener: AdapterListener) = Unit
}