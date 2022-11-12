package com.example.yumarketforowners.data.remote.datasource.item

import android.util.Log
import com.example.yumarketforowners.data.remote.dto.item.ItemDto
import com.example.yumarketforowners.di.singleton.Dispatcher
import com.example.yumarketforowners.di.singleton.DispatcherType
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FirebaseItemRemoteDataSource"

@Singleton
class FirebaseItemRemoteDataSource @Inject constructor(
    private val database: FirebaseDatabase,
    @Dispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher
) : ItemRemoteDataSource {

    private lateinit var reference: DatabaseReference

    override fun getItemsByMarketId(marketId: Long): Flow<List<ItemDto>> {
        reference = database.getReference("/marketItems/${marketId}/")

        return callbackFlow {
            reference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    trySend(snapshot.getValue<List<ItemDto>>() ?: emptyList())
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e(TAG, "onCancelled: $error")
                }
            })

            awaitClose()
        }
    }

    override suspend fun getSingleItemById(itemId: Long): ItemDto = withContext(ioDispatcher) {
        val resultValue = reference.child(itemId.toString()).get().await()
            .getValue(ItemDto::class.java) as ItemDto

        Log.d(TAG, "getSingleItemById: $resultValue")
        return@withContext resultValue
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
        reference.child(itemToAdd.id.toString()).setValue(itemToAdd)
    }
}