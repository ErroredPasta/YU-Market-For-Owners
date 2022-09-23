package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.model.orderlist.DeliveryType
import com.example.yumarketforowners.domain.model.orderlist.Order
import com.example.yumarketforowners.domain.model.orderlist.OrderState
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType

class FakeOrderRepository : OrderRepository {
    private val orders = (1..10).map {
        Order(
            id = it.toLong(),
            orderItems = (it..it + 1).map { itemIndex ->
                Item(
                    id = itemIndex.toLong(),
                    name = "name $itemIndex",
                    count = itemIndex,
                    price = itemIndex,
                    saleRatio = itemIndex,
                    imageUrl = "imageUrl $itemIndex",
                    available = true,
                    cellType = CellType.ORDER_ITEM_CELL
                )
            },
            orderId = "orderId $it",
            deliveryType = DeliveryType.values()[it % 3],
            orderTime = it.toLong(),
            telePhoneNumber = "telePhoneNumber $it",
            request = "request $it",
            orderState = OrderState.values()[it % 3]
        )
    }.toMutableList()

    override suspend fun getOrderListByMarketId(marketId: Long): List<Order> = orders
}