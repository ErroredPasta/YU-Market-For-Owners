package com.example.yumarketforowners.orderlist.data.datasource

import android.util.Log
import com.example.yumarketforowners.orderlist.data.dto.OrderDto
import com.example.yumarketforowners.core.di.Dispatcher
import com.example.yumarketforowners.core.di.DispatcherType
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FirebaseOrderRemoteDataSource"

@Singleton
class FirebaseOrderRemoteDataSource @Inject constructor(
    private val database: FirebaseDatabase,
    @Dispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher
) : OrderRemoteDataSource {

    private var reference: DatabaseReference =
        database.getReference("/orders/cc898844-8f2f-451e-bccf-2e84cb195c46")

    override val orderListFlow: Flow<List<OrderDto>> = callbackFlow {
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                trySend(snapshot.getValue<List<OrderDto>>() ?: emptyList())
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG, "onCancelled: $error")
            }
        })

        awaitClose()
    }

    override suspend fun getOrderListByMarketId(marketId: String): List<OrderDto> {
        reference = database.getReference("/orders/${marketId}")

        return emptyList()
    }

    override suspend fun getOrderByOrderId(orderId: Long): OrderDto? {
        TODO("Not yet implemented")
    }

    override suspend fun updateOrderState(orderId: Long, orderState: OrderState) =
        withContext<Unit>(ioDispatcher) {
            val updateMap = mapOf(
                "orderState" to orderState.name
            )

            reference.child(orderId.toString()).updateChildren(updateMap)
        }
}