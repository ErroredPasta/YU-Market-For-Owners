package com.example.yumarketforowners.data.remote.dto.item

// CRUD
data class ItemDto(
    val id: Long, // not updatable
    val name: String, // not updatable
    val description: String,
    val stock: Int,
    val price: Int,
    val discountedPrice: Int,
    val imageUrl: String? = null,
    val optionGroups: List<OptionGroupDto>,
    val available: Boolean
)

data class OptionGroupDto(
    val id: Long,
    val name: String,
    val options: List<OptionDto>,
    val selectRange: IntRange
)

data class OptionDto(
    val id: Long,
    val name: String,
    val additionalPrice: Int
)