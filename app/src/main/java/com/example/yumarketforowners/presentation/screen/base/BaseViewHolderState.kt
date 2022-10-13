package com.example.yumarketforowners.presentation.screen.base

import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType

abstract class BaseViewHolderState(
    open val id: Long,
    open val cellType: CellType
) {
    open fun isTheSame(other: BaseViewHolderState) =
        this.id == other.id && this.cellType == other.cellType
}