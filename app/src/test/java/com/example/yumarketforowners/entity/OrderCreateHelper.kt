package com.example.yumarketforowners.entity

import com.example.yumarketforowners.domain.model.order.*
import java.time.LocalTime

fun createOrder(
    it: Int,
    orderState: OrderState = OrderState.values()[it % OrderState.values().size]
) = Order(
    id = it.toLong(),
    orderItems = (it..it + 1).map { orderItem ->
        createOrderItem(orderItem)
    },
    deliveryType = DeliveryType.values()[it % 3],
    orderedAt = it.toLong(),
    orderMakerId = it.toLong(),
    request = "request $it",
    orderState = orderState,
    totalPrice = (it * it * 10000) + ((it + 1) * (it + 1) * 10000),
    deliveryFee = it * 1000,
    deliveryTime = Pair(
        LocalTime.of(it % 24, it % 61),
        LocalTime.of((it + 1) % 24, it % 61)
    )
)

private fun createOrderItem(it: Int) = OrderItem(
    id = it.toLong(),
    name = "name $it",
    imageUrl = "imageUrl $it",
    amount = it,
    pricePerItem = it * 10000,
    orderOptionGroups = (it..it + 3).map { orderOptionGroup ->
        OrderOptionGroup(
            orderOptionGroup.toLong(),
            (orderOptionGroup..orderOptionGroup + 3).map { orderOption ->
                OrderOption(
                    id = orderOption.toLong(),
                    name = "name $orderOption",
                    checked = orderOption % 2 == 0
                )
            }
        )
    }
)
