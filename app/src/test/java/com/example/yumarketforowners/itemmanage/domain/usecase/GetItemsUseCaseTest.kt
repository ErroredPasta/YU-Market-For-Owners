package com.example.yumarketforowners.itemmanage.domain.usecase

import com.example.yumarketforowners.itemmanage.domain.repository.ItemRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetItemsUseCaseTest {

    private lateinit var sut: GetItemsUseCase

    // region test doubles =========================================================================
    private lateinit var fakeRepository: ItemRepository
    // endregion test doubles ======================================================================


    @Before
    fun setup() {
        fakeRepository = FakeItemRepository()

        sut = GetItemsUseCase(fakeRepository)
    }

    @Test
    fun `get available items`() = runTest {
        // act
        val result = sut(marketId = "1", available = true).first()

        // assert
        for (item in result) {
            assertThat(item.available).isTrue()
        }
    }

    @Test
    fun `get unavailable items`() = runTest {
        // act
        val result = sut(marketId = "1", available = false).first()

        // assert
        for (item in result) {
            assertThat(item.available).isFalse()
        }
    }
}