package com.example.yumarketforowners.presentation.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.yumarketforowners.presentation.recyclerview.viewholder.BaseViewHolder
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import kotlin.reflect.full.primaryConstructor

object ViewHolderMapper {
    @Suppress("UNCHECKED_CAST")
    fun <M : BaseViewHolderState> map(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        cellType: CellType
    ) = cellType.clazz.primaryConstructor!!.call(
        DataBindingUtil.inflate(layoutInflater, cellType.layoutId, parent, false)
    ) as BaseViewHolder<*, M>
}
