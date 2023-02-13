package com.example.yumarketforowners.core.presentation.extension

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addItemDivider(orientation: Int) = this.addItemDecoration(
    DividerItemDecoration(
        this.context,
        orientation
    )
)
