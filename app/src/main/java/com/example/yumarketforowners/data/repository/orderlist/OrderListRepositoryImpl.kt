package com.example.yumarketforowners.data.repository.orderlist

import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.domain.model.itemmanage.ItemModel
import com.example.yumarketforowners.domain.model.orderlist.DeliveryType
import com.example.yumarketforowners.domain.model.orderlist.OrderModel
import com.example.yumarketforowners.domain.repository.OrderListRepository
import com.example.yumarketforowners.presentation.screen.orderlist.OrderListContract.State
import com.example.yumarketforowners.presentation.screen.orderlist.OrderState
import javax.inject.Inject


class OrderListRepositoryImpl @Inject constructor() : OrderListRepository {
    private val testList
        get() = (0..9).map {
            OrderModel(
                id = it.toLong(),
                orderItems = (0..1).map { itemIndex ->
                    ItemModel(
                        id = itemIndex.toLong(),
                        name = "name $itemIndex",
                        count = itemIndex,
                        price = itemIndex,
                        saleRatio = itemIndex,
                        imageUrl = "https://picsum.photos/200",
                        available = true,
                        cellType = CellType.ORDER_ITEM_CELL
                    )
                },
                orderId = "order $it",
                deliveryType = DeliveryType.values()[it % 3],
                orderTime = System.currentTimeMillis(),
                telePhoneNumber = "telephone $it",
                request = "request $it",
                orderState = OrderState.values()[it % 3]
            )
        }

    override fun getOrderListByMarketId(marketId: Long): List<OrderModel> = testList
}