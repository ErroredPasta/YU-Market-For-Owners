package com.example.yumarketforowners.domain.model

import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType

abstract class BaseModel(
    open val id: Long,
    open val cellType: CellType
) {
    open fun isTheSame(other: BaseModel) =
        this.id == other.id && this.cellType == other.cellType
}