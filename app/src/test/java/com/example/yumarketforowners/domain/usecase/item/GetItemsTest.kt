package com.example.yumarketforowners.domain.usecase.item

import com.example.yumarketforowners.data.repository.FakeItemRepository
import com.example.yumarketforowners.domain.repository.ItemRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetItemsTest {
    private lateinit var sut: GetItems

    // region test doubles =========================================================================
    private lateinit var fakeRepository: ItemRepository
    // endregion test doubles ======================================================================

    @Before
    fun setup() {
        fakeRepository = FakeItemRepository()

        sut = GetItems(fakeRepository)
    }

    @Test
    fun `get available items`() = runTest {
        // act
        val result = sut(marketId = 0L, available = true)

        // assert
        for (item in result) {
            assertThat(item.available).isTrue()
        }
    }

    @Test
    fun `get unavailable items`() = runTest {
        // act
        val result = sut(marketId = 0L, available = false)

        // assert
        for (item in result) {
            assertThat(item.available).isFalse()
        }
    }
}