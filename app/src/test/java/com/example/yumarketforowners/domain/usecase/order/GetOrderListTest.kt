package com.example.yumarketforowners.domain.usecase.order

import com.example.yumarketforowners.data.repository.FakeOrderRepository
import com.example.yumarketforowners.domain.model.orderlist.OrderState
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class GetOrderListTest {
    private lateinit var sut: GetOrderList

    // region test doubles =========================================================================
    private lateinit var fakeRepository: FakeOrderRepository
    // endregion test doubles ======================================================================

    @Before
    fun setup() {
        fakeRepository = FakeOrderRepository()

        sut = GetOrderList(fakeRepository)
    }

    @Test
    fun `get pending orders correctly`() = runTest {
        // act
        val result = sut(marketId = 0L, orderState = OrderState.PENDING)

        // assert
        for (order in result) {
            assertThat(order.orderState).isEqualTo(OrderState.PENDING)
        }
    }

    @Test
    fun `get accepted orders correctly`() = runTest {
        // act
        val result = sut(marketId = 0L, orderState = OrderState.ACCEPTED)

        // assert
        for (order in result) {
            assertThat(order.orderState).isEqualTo(OrderState.ACCEPTED)
        }
    }

    @Test
    fun `get done orders correctly`() = runTest {
        // act
        val result = sut(marketId = 0L, orderState = OrderState.DONE)

        // assert
        for (order in result) {
            assertThat(order.orderState).isEqualTo(OrderState.DONE)
        }
    }
}