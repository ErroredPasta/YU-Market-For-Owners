package com.example.yumarketforowners.itemmanage.data.datasource

import android.util.Log
import com.example.yumarketforowners.itemmanage.data.dto.ItemDto
import com.example.yumarketforowners.core.di.Dispatcher
import com.example.yumarketforowners.core.di.DispatcherType
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FirebaseItemRemoteDataSource"

@Singleton
class FirebaseItemRemoteDataSource @Inject constructor(
    private val database: FirebaseDatabase,
    @Dispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher
) : ItemRemoteDataSource {

    private val nextItemId = AtomicLong(0L)

    @Volatile
    private lateinit var reference: DatabaseReference

    override fun getItemsByMarketId(marketId: String): Flow<List<ItemDto>> {
        reference = database.getReference("/marketItems/${marketId}/")

        return callbackFlow {
            reference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val itemList = (snapshot.getValue<List<ItemDto>>() ?: emptyList()).also {
                        nextItemId.set(it.size.toLong())
                    }

                    trySend(itemList)
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e(TAG, "onCancelled: $error")
                }
            })

            awaitClose()
        }
    }

    override suspend fun getSingleItemById(itemId: Long): ItemDto = withContext(ioDispatcher) {
        return@withContext reference.child(itemId.toString()).get().await()
            .getValue(ItemDto::class.java) as ItemDto
    }

    override suspend fun updateItem(updatedItem: ItemDto) = withContext<Unit>(ioDispatcher) {
        val updateMap = mapOf(
            "name" to updatedItem.name,
            "description" to updatedItem.description,
            "stock" to updatedItem.stock,
            "price" to updatedItem.price,
            "discountedPrice" to updatedItem.discountedPrice,
            "imageUrl" to updatedItem.imageUrl,
            "optionGroups" to updatedItem.optionGroups,
            "available" to updatedItem.available
        )

        reference.child(updatedItem.id.toString()).updateChildren(updateMap)
    }

    override suspend fun addItem(itemToAdd: ItemDto) = withContext<Unit>(ioDispatcher) {
        val item = itemToAdd.copy(id = nextItemId.getAndIncrement())
        reference.child(item.id.toString()).setValue(item)
    }
}