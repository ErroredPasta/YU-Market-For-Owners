package com.example.yumarketforowners.util.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.yumarketforowners.screen.ViewType
import com.example.yumarketforowners.screen.base.mvp.BaseView
import kotlin.reflect.full.primaryConstructor


object ViewFactory {
    @Suppress("UNCHECKED_CAST")
    fun <V : BaseView<*>> create(
        type: ViewType,
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): V {
        val (clazz, layoutId) = type

        return clazz.primaryConstructor!!.call(
            DataBindingUtil.inflate(inflater, layoutId, parent, false)
        ) as V
    }
}