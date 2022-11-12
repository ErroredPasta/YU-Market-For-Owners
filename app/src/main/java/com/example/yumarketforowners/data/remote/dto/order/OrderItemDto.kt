package com.example.yumarketforowners.data.remote.dto.order

// CR
// non-updatable entity
data class OrderItemDto(
    var id: Long = 0L,
    var name: String = "",
    var imageUrl: String? = null,
    var amount: Int = 0,
    var pricePerItem: Int = 0,
    var orderOptionGroupDtos: List<OrderOptionGroupDto> = emptyList()
)

// non-updatable entity
data class OrderOptionGroupDto(
    var id: Long = 0L,
    var orderOptionDtos: List<OrderOptionDto> = emptyList()
)

// non-updatable entity
data class OrderOptionDto(
    var id: Long = 0L,
    var name: String = "",
    var checked: Boolean = false
)
