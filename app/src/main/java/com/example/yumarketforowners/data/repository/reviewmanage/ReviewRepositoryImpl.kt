package com.example.yumarketforowners.data.repository.reviewmanage

import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.domain.model.itemmanage.ItemModel
import com.example.yumarketforowners.domain.model.orderlist.DeliveryType
import com.example.yumarketforowners.domain.model.orderlist.OrderModel
import com.example.yumarketforowners.domain.model.reviewmanage.ReviewModel
import com.example.yumarketforowners.domain.repository.ReviewOrChatRoomRepository
import com.example.yumarketforowners.presentation.screen.orderlist.OrderState
import com.example.yumarketforowners.presentation.screen.reviewmanage.ReviewManageContract.State
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor() : ReviewOrChatRoomRepository<ReviewModel> {
    private val testList get() = (0..9).map {
        ReviewModel(
            id = it.toLong(),
            writer = "writer $it",
            profileImageUrl = "https://picsum.photos/200",
            content = "content $it",
            order = OrderModel(
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
            ),
            writeTime = System.currentTimeMillis()
        )
    }

    override fun getAllByMarketId(marketId: Long): State = State.Success(data = testList)
}