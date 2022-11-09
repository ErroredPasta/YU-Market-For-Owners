package com.example.yumarketforowners.data.remote.datasource.item

import android.util.Log
import com.example.yumarketforowners.data.remote.dto.item.ItemDto
import com.example.yumarketforowners.data.remote.dto.item.OptionDto
import com.example.yumarketforowners.data.remote.dto.item.OptionGroupDto
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FakeItemRemoteDataSource"

@Singleton
class FakeItemRemoteDataSource @Inject constructor() : ItemRemoteDataSource {

    private var itemList = (1..10).map {
        createItemDto(it)
    }.toMutableList()

    private val _itemListFlow = MutableStateFlow(itemList)

    override fun getItemsByMarketId(marketId: Long) = _itemListFlow.asStateFlow()
    override suspend fun getSingleItemById(itemId: Long) =
        checkNotNull(itemList.find { it.id == itemId }) {
            "id가 ${itemId}인 item이 없습니다."
        }

    override suspend fun updateItem(updatedItem: ItemDto) = withContext<Unit>(NonCancellable) {
        val index = itemList.indexOfFirst { it.id == updatedItem.id }

        if (index != -1) {
            _itemListFlow.update {
                it.toMutableList().apply { this[index] = updatedItem }
            }
            itemList = _itemListFlow.value
            Log.d(TAG, "updateItem: ${itemList[index]}")
        } else {
            Log.d(TAG, "updateItem: no update")
        }
    }

    override suspend fun addItem(itemToAdd: ItemDto) {
        _itemListFlow.update {
            itemList.toMutableList().apply { add(itemToAdd.copy(id = itemList.size + 1L)) }
        }

        itemList = _itemListFlow.value
        Log.d(TAG, "addItem: ${itemList.last()}")
    }

    // region temporary helper functions ===========================================================

    private fun createItemDto(it: Int) = ItemDto(
        id = it.toLong(),
        name = "name $it",
        description = "description $it",
        stock = it,
        price = it * 20000,
        discountedPrice = it * 10000,
        imageUrl = "https://picsum.photos/200",
        optionGroups = createOptionGroupDtos((it..it + 3)),
        available = it % 2 == 0
    )

    private fun createOptionGroupDtos(range: IntRange) = range.map {
        OptionGroupDto(
            id = it.toLong(),
            name = "name $it",
            options = createOptionDtos((it..it + 3)),
            selectRange = it..it + 1
        )
    }

    private fun createOptionDtos(range: IntRange) = range.map {
        OptionDto(
            id = it.toLong(),
            name = "name $it",
            additionalPrice = it * 1000
        )
    }

    // endregion temporary helper functions ========================================================

}