package com.example.yumarketforowners.data.repository

import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.model.orderlist.DeliveryType
import com.example.yumarketforowners.domain.model.orderlist.Order
import com.example.yumarketforowners.domain.model.orderlist.OrderState
import com.example.yumarketforowners.domain.model.reviewmanage.Review
import com.example.yumarketforowners.domain.repository.ReviewRepository
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType

class FakeReviewRepository : ReviewRepository {
    private val reviews = (1..10).map {
        Review(
            id = it.toLong(),
            writer = "writer $it",
            profileImageUrl = "profileImageUrl $it",
            content = "content $it",
            order = Order(
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
                orderId = "order $it",
                deliveryType = DeliveryType.values()[it % 3],
                orderTime = it.toLong(),
                telePhoneNumber = "telePhoneNumber $it",
                request = "request $it",
                orderState = OrderState.values()[it % 3]
            ),
            writeTime = it.toLong()
        )
    }.toMutableList()

    override suspend fun getAllReviewsByMarketId(marketId: Long): List<Review> = reviews
}