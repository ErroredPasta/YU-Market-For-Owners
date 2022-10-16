package com.example.yumarketforowners.data.remote.datasource.item

import com.example.yumarketforowners.data.remote.dto.item.ItemDto
import com.example.yumarketforowners.data.remote.dto.item.OptionDto
import com.example.yumarketforowners.data.remote.dto.item.OptionGroupDto
import javax.inject.Inject

class FakeItemRemoteDataSource @Inject constructor() : ItemRemoteDataSource {

    private val testList = (0..9).map {
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
    }

    override suspend fun getItemsByMarketId(marketId: Long) = testList

    // region temporary helper functions ===========================================================

    private fun createOptionGroupDtos(range: IntRange) = range.map {
        OptionGroupDto(
            id = it.toLong(),
            options = createOptionDtos((it..it + 3)),
            selectRange = Pair(it, it + 1)
        )
    }

    private fun createOptionDtos(range: IntRange) = range.map {
        OptionDto(
            id = it.toLong(),
            name = "name $it"
        )
    }

    // endregion temporary helper functions ========================================================

}