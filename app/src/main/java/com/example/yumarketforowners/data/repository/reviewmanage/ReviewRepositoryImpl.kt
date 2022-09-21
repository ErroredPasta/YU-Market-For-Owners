package com.example.yumarketforowners.data.repository.reviewmanage

import com.example.yumarketforowners.di.singleton.Dispatcher
import com.example.yumarketforowners.di.singleton.DispatcherType
import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.model.orderlist.DeliveryType
import com.example.yumarketforowners.domain.model.orderlist.Order
import com.example.yumarketforowners.domain.model.reviewmanage.Review
import com.example.yumarketforowners.domain.repository.ReviewRepository
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import com.example.yumarketforowners.domain.model.orderlist.OrderState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    @Dispatcher(DispatcherType.IO) private val dispatcher: CoroutineDispatcher
) : ReviewRepository {
    private val testList
        get() = (0..9).map {
            Review(
                id = it.toLong(),
                writer = "writer $it",
                profileImageUrl = "https://picsum.photos/200",
                content = "content $it",
                order = Order(
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
                ),
                writeTime = System.currentTimeMillis()
            )
        }

    override suspend fun getAllReviewsByMarketId(marketId: Long): List<Review> = withContext(dispatcher) {
        testList
    }
}