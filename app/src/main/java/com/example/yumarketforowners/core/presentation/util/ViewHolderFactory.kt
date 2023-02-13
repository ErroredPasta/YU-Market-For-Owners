package com.example.yumarketforowners.core.presentation.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.yumarketforowners.core.presentation.base.BaseViewHolderState
import com.example.yumarketforowners.core.presentation.viewholder.BaseViewHolder
import com.example.yumarketforowners.core.presentation.viewholder.CellType
import kotlin.reflect.full.primaryConstructor

@Suppress("UNCHECKED_CAST")
fun <M : BaseViewHolderState> createViewHolder(
    layoutInflater: LayoutInflater,
    parent: ViewGroup?,
    cellType: CellType
) = cellType.clazz.primaryConstructor!!.call(
    DataBindingUtil.inflate(layoutInflater, cellType.layoutId, parent, false)
) as BaseViewHolder<*, M>
