package com.example.yumarketforowners.domain.model.order

data class OrderItem(
    val id: Long,
    val name: String,
    val imageUrl: String?,
    val amount: Int,
    val pricePerItem: Int,
    val orderOptionGroups: List<OrderOptionGroup>
)

data class OrderOptionGroup(
    val id: Long,
    val orderOptions: List<OrderOption>
)

data class OrderOption(
    val id: Long,
    val name: String,
    val checked: Boolean
)

