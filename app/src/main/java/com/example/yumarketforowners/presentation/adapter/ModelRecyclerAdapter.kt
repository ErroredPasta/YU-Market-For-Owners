package com.example.yumarketforowners.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.yumarketforowners.domain.model.BaseModel
import com.example.yumarketforowners.presentation.recyclerview.listener.AdapterListener
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.presentation.util.ViewHolderMapper

class ModelRecyclerAdapter<M : BaseModel>(
    private val adapterListener: AdapterListener? = null
) : ListAdapter<BaseModel, BaseViewHolder<*, M>>(ModelDiffCallback) {

    private var modelList: List<BaseModel> = emptyList()

    override fun getItemViewType(position: Int): Int = modelList[position].cellType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, M> =
        ViewHolderMapper.map(
            LayoutInflater.from(parent.context),
            parent,
            CellType.values()[viewType]
        )

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: BaseViewHolder<*, M>, position: Int) {
        holder.bindData(modelList[position] as M)
        adapterListener?.let { holder.bindListener(it) }
    }

    override fun submitList(list: List<BaseModel>?) {
        list?.let { modelList = it }
        super.submitList(list)
    }

    companion object ModelDiffCallback : DiffUtil.ItemCallback<BaseModel>() {
        override fun areItemsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean =
            oldItem.isTheSame(newItem)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: BaseModel, newItem: BaseModel): Boolean =
            oldItem == newItem
    }
}