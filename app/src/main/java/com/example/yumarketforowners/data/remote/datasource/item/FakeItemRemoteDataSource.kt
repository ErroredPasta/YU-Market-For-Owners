package com.example.yumarketforowners.data.remote.datasource.item

import android.util.Log
import com.example.yumarketforowners.data.remote.dto.item.ItemDto
import com.example.yumarketforowners.data.remote.dto.item.OptionDto
import com.example.yumarketforowners.data.remote.dto.item.OptionGroupDto
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "FakeItemRemoteDataSource"

@Singleton
class FakeItemRemoteDataSource @Inject constructor() : ItemRemoteDataSource {

    private val itemList = (0..9).map {
        ItemDto(
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
    }.toMutableList()

    override suspend fun getItemsByMarketId(marketId: Long) = itemList
    override suspend fun getSingleItemById(itemId: Long) =
        checkNotNull(itemList.find { it.id == itemId }) {
            "id가 ${itemId}인 item이 없습니다."
        }

    override suspend fun updateItem(updatedItem: ItemDto) {
        val index = itemList.indexOfFirst { it.id == updatedItem.id }

        if (index != -1) {
            itemList[index] = updatedItem
            Log.d(TAG, "updateItem: ${itemList[index]}")
        } else {
            Log.d(TAG, "updateItem: no update")
        }
    }

    // region temporary helper functions ===========================================================

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