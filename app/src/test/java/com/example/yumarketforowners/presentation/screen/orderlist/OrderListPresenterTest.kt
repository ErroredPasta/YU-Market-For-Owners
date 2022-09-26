package com.example.yumarketforowners.presentation.screen.orderlist

import com.example.yumarketforowners.coroutine.TestCoroutineRule
import com.example.yumarketforowners.domain.model.itemmanage.Item
import com.example.yumarketforowners.domain.model.orderlist.DeliveryType
import com.example.yumarketforowners.domain.model.orderlist.Order
import com.example.yumarketforowners.domain.model.orderlist.OrderState
import com.example.yumarketforowners.domain.usecase.order.GetOrderList
import com.example.yumarketforowners.presentation.recyclerview.viewholder.CellType
import io.mockk.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import javax.inject.Provider

@ExperimentalCoroutinesApi
class OrderListPresenterTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var sut: OrderListPresenter

    // region test doubles =========================================================================
    private lateinit var viewMock: OrderListInnerFragment
    private lateinit var getOrderListMock: GetOrderList
    private lateinit var scopeProviderMock: Provider<CoroutineScope>
    // endregion test doubles ======================================================================

    // region constants ============================================================================
    private val testMarketId = 0L
    // endregion constants =========================================================================

    @Before
    fun setup() {
        viewMock = mockk(relaxed = true)
        getOrderListMock = mockk()
        scopeProviderMock = mockk()

        sut = OrderListPresenter(
            view = viewMock,
            getOrderList = getOrderListMock,
            scopeProvider = scopeProviderMock
        )

        every { scopeProviderMock.get() } returns TestScope()
    }

    @Test
    fun `on request, show loading then hide when request complete`() = runTest {
        // arrange
        getOrderListReturns(orderState = OrderState.PENDING)

        // act
        sut.requestData(marketId = testMarketId, orderState = OrderState.PENDING)
        advanceUntilIdle()

        // assert
        verifyOrder {
            viewMock.loading(show = true)
            viewMock.loading(show = false)
        }
    }

    @Test
    fun `request pending order list, on success`() = runTest {
        // arrange
        val expected = getOrderListReturns(orderState = OrderState.PENDING)

        // act
        sut.requestData(marketId = testMarketId, orderState = OrderState.PENDING)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataSuccess(expected) }
    }

    @Test
    fun `request pending order list, on error`() = runTest {
        // arrange
        getOrderListFailed()

        // act
        sut.requestData(marketId = testMarketId, orderState = OrderState.PENDING)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataError(any()) }
    }

    @Test
    fun `request accepted order list, on success`() = runTest {
        // arrange
        val expected = getOrderListReturns(orderState = OrderState.ACCEPTED)

        // act
        sut.requestData(marketId = testMarketId, orderState = OrderState.ACCEPTED)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataSuccess(expected) }
    }

    @Test
    fun `request accepted order list, on error`() = runTest {
        // arrange
        getOrderListFailed()

        // act
        sut.requestData(marketId = testMarketId, orderState = OrderState.ACCEPTED)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataError(any()) }
    }

    @Test
    fun `request done order list, on success`() = runTest {
        // arrange
        val expected = getOrderListReturns(orderState = OrderState.DONE)

        // act
        sut.requestData(marketId = testMarketId, orderState = OrderState.DONE)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataSuccess(expected) }
    }

    @Test
    fun `request done order list, on error`() = runTest {
        // arrange
        getOrderListFailed()

        // act
        sut.requestData(marketId = testMarketId, orderState = OrderState.DONE)
        advanceUntilIdle()

        // assert
        verify { viewMock.onRequestDataError(any()) }
    }

    // region helper methods =======================================================================
    private fun getOrderListReturns(orderState: OrderState): List<Order> {
        val returnValue = createOrderList(orderState)

        coEvery {
            getOrderListMock(marketId = any(), orderState = orderState)
        } returns returnValue

        return returnValue
    }

    private fun getOrderListFailed() {
        coEvery { getOrderListMock(marketId = any(), orderState = any()) } returns null
    }

    private fun createOrderList(orderState: OrderState) = (1..10).map {
        Order(
            id = it.toLong(),
            orderItems = (it..it + 1).map { itemIndex ->
                Item(
                    id = itemIndex.toLong(),
                    name = "name $itemIndex",
                    count = itemIndex,
                    price = itemIndex,
                    saleRatio = itemIndex,
                    imageUrl = "imageUrl $itemIndex",
                    available = true,
                    cellType = CellType.ORDER_ITEM_CELL
                )
            },
            orderId = "orderId $it",
            deliveryType = DeliveryType.values()[it % 3],
            orderTime = it.toLong(),
            telePhoneNumber = "telePhoneNumber $it",
            request = "request $it",
            orderState = orderState
        )
    }
    // endregion helper methods ====================================================================

    // region test double classes ==================================================================

    // endregion test doubles classes ==============================================================
}