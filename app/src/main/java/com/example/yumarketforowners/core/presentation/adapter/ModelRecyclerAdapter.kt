package com.example.yumarketforowners.core.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.util.createViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType

class ModelRecyclerAdapter<M : BaseViewHolderState> :
    ListAdapter<BaseViewHolderState, BaseViewHolder<*, M>>(ModelDiffCallback) {

    private var modelList: List<BaseViewHolderState> = emptyList()

    override fun getItemViewType(position: Int): Int = modelList[position].cellType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, M> =
        createViewHolder(
            LayoutInflater.from(parent.context), parent, CellType.values()[viewType]
        )

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<*, M>, position: Int) {
        holder.bindData(modelList[position] as M)
    }

    override fun submitList(list: List<BaseViewHolderState>?) {
        list?.let { modelList = it }
        super.submitList(list)
    }

    companion object ModelDiffCallback : DiffUtil.ItemCallback<BaseViewHolderState>() {
        override fun areItemsTheSame(
            oldItem: BaseViewHolderState, newItem: BaseViewHolderState
        ) = oldItem.isTheSame(newItem)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: BaseViewHolderState, newItem: BaseViewHolderState
        ) = oldItem == newItem
    }
}