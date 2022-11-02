package com.example.yumarketforowners.domain.model.item

data class Item(
    val id: Long,
    val name: String,
    val description: String,
    val stock: Int,
    val price: Int,
    val discountedPrice: Int,
    val imageUrl: String?,
    val optionGroups: List<OptionGroup>,
    val available: Boolean
)

data class OptionGroup(
    val id: Long,
    val name: String,
    val options: List<Option>,
    val selectRange: IntRange
)

data class Option(
    val id: Long,
    val name: String,
    val additionalPrice: Int
)
