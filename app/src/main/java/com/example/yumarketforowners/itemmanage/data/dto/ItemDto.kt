package com.example.yumarketforowners.itemmanage.data.dto

// CRUD
data class ItemDto(
    var id: Long = 0L, // not updatable
    var name: String = "",
    var description: String = "",
    var stock: Int = 0,
    var price: Int = 0,
    var discountedPrice: Int = 0,
    var imageUrl: String? = null,
    var optionGroups: List<OptionGroupDto> = emptyList(),
    var available: Boolean = false
)

data class OptionGroupDto(
    var id: Long = 0L,
    var name: String = "",
    var options: List<OptionDto> = emptyList(),
    var minSelect: Int = 0,
    var maxSelect: Int = 0
)

data class OptionDto(
    var id: Long = 0L,
    var name: String = "",
    var additionalPrice: Int = 0
)