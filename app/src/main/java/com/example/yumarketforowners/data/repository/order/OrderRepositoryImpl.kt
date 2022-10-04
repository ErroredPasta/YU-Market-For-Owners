package com.example.yumarketforowners.data.repository.order

import com.example.yumarketforowners.di.singleton.Dispatcher
import com.example.yumarketforowners.di.singleton.DispatcherType
import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.model.orderlist.DeliveryType
import com.example.yumarketforowners.domain.model.orderlist.Order
import com.example.yumarketforowners.domain.repository.OrderRepository
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.domain.model.orderlist.OrderState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


class OrderRepositoryImpl @Inject constructor(
    @Dispatcher(DispatcherType.IO) private val dispatcher: CoroutineDispatcher
) : OrderRepository {
    private val testList
        get() = (0..9).map {
            Order(
                id = it.toLong(),
                orderItems = (0..1).map { itemIndex ->
                    Item(
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

    override suspend fun getOrderListByMarketId(marketId: Long): List<Order> =
        withContext(dispatcher) {
            testList
        }
}