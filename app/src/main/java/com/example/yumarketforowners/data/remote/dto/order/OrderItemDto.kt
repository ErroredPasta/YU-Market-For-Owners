package com.example.yumarketforowners.data.remote.dto.order

// CR
// non-updatable entity
data class OrderItemDto(
    val id: Long,
    val name: String,
    val imageUrl: String? = null,
    val amount: Int,
    val pricePerItem: Int,
    val orderOptionGroupDtos: List<OrderOptionGroupDto>
)

// non-updatable entity
data class OrderOptionGroupDto(
    val id: Long,
    val orderOptionDtos: List<OrderOptionDto>
)

// non-updatable entity
data class OrderOptionDto(
    val id: Long,
    val name: String,
    val checked: Boolean
)
