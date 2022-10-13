package com.example.yumarketforowners.data.mapper.order

import com.example.yumarketforowners.data.remote.dto.order.OrderDto
import com.example.yumarketforowners.data.remote.dto.order.OrderItemDto
import com.example.yumarketforowners.data.remote.dto.order.OrderOptionDto
import com.example.yumarketforowners.data.remote.dto.order.OrderOptionGroupDto
import com.example.yumarketforowners.domain.model.order.Order
import com.example.yumarketforowners.domain.model.order.OrderItem
import com.example.yumarketforowners.domain.model.order.OrderOption
import com.example.yumarketforowners.domain.model.order.OrderOptionGroup

fun Order.toOrderDto(marketId: Long) = OrderDto(
    id = id,
    marketId = marketId,
    orderedAt = orderedAt,
    orderItemDtos = orderItems.toOrderItemDtos(),
    totalPrice = totalPrice,
    orderState = orderState,
    deliveryFee = deliveryFee,
    deliveryTime = deliveryTime,
    deliveryType = deliveryType,
    orderMakerId = orderMakerId,
    request = request
)

fun OrderDto.toOrder() = Order(
    id,
    orderedAt = orderedAt,
    orderItems = orderItemDtos.toOrderItems(),
    totalPrice = totalPrice,
    orderState = orderState,
    deliveryFee = deliveryFee,
    deliveryTime = deliveryTime,
    deliveryType = deliveryType,
    orderMakerId = orderMakerId,
    request = request
)

private fun List<OrderItem>.toOrderItemDtos() = map {
    OrderItemDto(
        id = it.id,
        name = it.name,
        amount = it.amount,
        pricePerItem = it.pricePerItem,
        orderOptionGroupDtos = it.orderOptionGroups.toOrderOptionGroupDtos()
    )
}

private fun List<OrderOptionGroup>.toOrderOptionGroupDtos() = map {
    OrderOptionGroupDto(
        id = it.id,
        orderOptionDtos = it.orderOptions.toOrderOptionDtos()
    )
}

private fun List<OrderOption>.toOrderOptionDtos() = map {
    OrderOptionDto(
        id = it.id,
        name = it.name,
        checked = it.checked
    )
}

private fun List<OrderItemDto>.toOrderItems() = map {
    OrderItem(
        id = it.id,
        name = it.name,
        imageUrl = it.imageUrl,
        amount = it.amount,
        pricePerItem = it.pricePerItem,
        orderOptionGroups = it.orderOptionGroupDtos.toOrderOptionGroups()
    )
}

private fun List<OrderOptionGroupDto>.toOrderOptionGroups() = map {
    OrderOptionGroup(
        id = it.id,
        orderOptions = it.orderOptionDtos.toOrderOptions()
    )
}

private fun List<OrderOptionDto>.toOrderOptions() = map {
    OrderOption(
        id = it.id,
        name = it.name,
        checked = it.checked
    )
}
