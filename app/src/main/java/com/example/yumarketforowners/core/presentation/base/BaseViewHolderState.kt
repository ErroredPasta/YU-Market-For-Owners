package com.example.yumarketforowners.core.presentation.base

import com.example.yumarketforowners.core.presentation.viewholder.CellType

abstract class BaseViewHolderState(
    open val id: Long,
    open val cellType: CellType
) {
    open fun isTheSame(other: BaseViewHolderState) =
        this.id == other.id && this.cellType == other.cellType
}