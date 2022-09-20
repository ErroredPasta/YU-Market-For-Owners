package com.example.yumarketforowners.domain.model.itemmanage

import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.domain.model.BaseModel

data class Item(
    override val id: Long,
    val name: String,
    var count: Int,
    val price: Int,
    val saleRatio: Int,
    val imageUrl: String,
    var available: Boolean,
    var checkedForStateChange: Boolean = false,
    override val cellType: CellType = CellType.ITEM_CELL
) : BaseModel(id, cellType)
