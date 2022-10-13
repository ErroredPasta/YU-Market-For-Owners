package com.example.yumarketforowners.data.remote.datasource.order

import com.example.yumarketforowners.data.remote.dto.order.OrderDto
import com.example.yumarketforowners.data.remote.dto.order.OrderItemDto
import com.example.yumarketforowners.data.remote.dto.order.OrderOptionDto
import com.example.yumarketforowners.data.remote.dto.order.OrderOptionGroupDto
import com.example.yumarketforowners.domain.model.order.DeliveryType
import com.example.yumarketforowners.domain.model.order.OrderState
import java.time.LocalTime
import javax.inject.Inject

class FakeOrderRemoteDataSource @Inject constructor() : OrderRemoteDataSource {

    private val testList = (0..9).map {
        OrderDto(
            id = it.toLong(),
            marketId = it.toLong(),
            orderedAt = it.toLong(),
            orderItemDtos = createOrderItemDtos((it..it + 1)),
            totalPrice = calculateTotalPrice((it..it + 1)),
            orderState = OrderState.values()[it % OrderState.values().size],
            deliveryFee = it,
            deliveryTime = Pair(
                LocalTime.of(it % 24, it % 61),
                LocalTime.of((it + 1) % 24, it % 61)
            ),
            deliveryType = DeliveryType.values()[it % DeliveryType.values().size],
            orderMakerId = it.toLong(),
            request = "request $it"
        )
    }

    override suspend fun getOrderListByMarketId(marketId: Long) = testList

    override suspend fun getOrderByOrderId(orderId: Long) = testList.find { it.id == orderId }

    // region temporary helper functions ===========================================================

    private fun createOrderItemDtos(range: IntRange) = range.map {
        OrderItemDto(
            id = it.toLong(),
            name = "name $it",
            imageUrl = "https://picsum.photos/200",
            amount = it,
            pricePerItem = it * 10000,
            orderOptionGroupDtos = createOrderOptionGroupDtos((it..it + 3))
        )
    }

    private fun createOrderOptionGroupDtos(range: IntRange) = range.map {
        OrderOptionGroupDto(
            id = it.toLong(),
            orderOptionDtos = createOrderOptionDtos((it..it + 3))
        )
    }

    private fun createOrderOptionDtos(range: IntRange) = range.map {
        OrderOptionDto(
            id = it.toLong(),
            name = "name $it",
            checked = it % 2 == 0
        )
    }

    private fun calculateTotalPrice(range: IntRange) = range.reduce { acc, i ->
        acc + (i * i * 10000)
    }

    // endregion temporary helper functions ========================================================
}