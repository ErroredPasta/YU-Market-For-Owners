package com.example.yumarketforowners.orderlist.data.datasource

import android.util.Log
import com.example.yumarketforowners.orderlist.data.dto.OrderDto
import com.example.yumarketforowners.orderlist.data.dto.OrderItemDto
import com.example.yumarketforowners.orderlist.data.dto.OrderOptionDto
import com.example.yumarketforowners.orderlist.data.dto.OrderOptionGroupDto
import com.example.yumarketforowners.orderlist.domain.model.DeliveryType
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.google.gson.Gson
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import java.time.LocalTime
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FakeOrderRemoteDataSource"

@Singleton
class FakeOrderRemoteDataSource @Inject constructor() : OrderRemoteDataSource {

    private val orderList = (0..9).map {
        OrderDto(
            id = it.toLong(),
            marketId = 0L,
            orderedAt = it.toLong(),
            orderItemDtos = createOrderItemDtos((it..it + 1)),
            totalPrice = calculateTotalPrice((it..it + 1)),
            orderState = OrderState.values()[it % OrderState.values().size].name,
            deliveryFee = it,
            deliveryTime = Pair(
                LocalTime.of(it % 24, it % 61),
                LocalTime.of((it + 1) % 24, it % 61)
            ),
            deliveryType = DeliveryType.values()[it % DeliveryType.values().size].name,
            orderMakerId = it.toLong(),
            request = "request $it"
        )
    }.toMutableList()

    private val _orderListFlow = MutableStateFlow(orderList)
    override val orderListFlow: Flow<List<OrderDto>> = _orderListFlow.asStateFlow()

    override suspend fun getOrderListByMarketId(marketId: String): List<OrderDto> {
        TODO("not implemented")
    }

    override suspend fun getOrderByOrderId(orderId: Long) = orderList.find { it.id == orderId }.also {
        Log.d(TAG, "getOrderByOrderId: ${Gson().toJson(it)}")
    }

    override suspend fun updateOrderState(orderId: Long, orderState: OrderState) =
        withContext<Unit>(NonCancellable) {
            val index = orderList.indexOfFirst { it.id == orderId }
            val updatedOrder = orderList.find { it.id == orderId }?.copy(
                orderState = orderState.name
            )

            updatedOrder?.let {
                _orderListFlow.update {
                    it.toMutableList().also { list -> list[index] = updatedOrder }
                }

                Log.d(TAG, "updateOrderState: ${_orderListFlow.value[index]}")
            } ?: Log.d(TAG, "updateOrderState: no update")
        }

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