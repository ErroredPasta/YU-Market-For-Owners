package com.example.yumarketforowners.orderlist.domain.usecase

import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class GetOrderListUseCaseTest {
    private lateinit var sut: GetOrderListUseCase

    // region test doubles =========================================================================
    private lateinit var fakeRepository: FakeOrderRepository
    // endregion test doubles ======================================================================

    // region constants ============================================================================
    private val testMarketId = "0L"
    // endregion constants =========================================================================

    @Before
    fun setup() {
        fakeRepository = FakeOrderRepository()

        sut = GetOrderListUseCase(fakeRepository)
    }

    @Test
    fun `get pending orders correctly`() = runTest {
        // act
        val result = sut(marketId = testMarketId, orderState = OrderState.PENDING)

        // assert
        for (order in result) {
            assertThat(order.orderState).isEqualTo(OrderState.PENDING)
        }
    }

    @Test
    fun `get accepted orders correctly`() = runTest {
        // act
        val result = sut(marketId = testMarketId, orderState = OrderState.ACCEPTED)

        // assert
        for (order in result) {
            assertThat(order.orderState).isEqualTo(OrderState.ACCEPTED)
        }
    }

    @Test
    fun `get done orders correctly`() = runTest {
        // act
        val result = sut(marketId = testMarketId, orderState = OrderState.DONE)

        // assert
        for (order in result) {
            assertThat(order.orderState).isEqualTo(OrderState.DONE)
        }
    }
}