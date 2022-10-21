package com.example.yumarketforowners.presentation.screen.orderlist
//
//import com.example.yumarketforowners.coroutine.TestCoroutineRule
//import com.example.yumarketforowners.domain.model.order.*
//import com.example.yumarketforowners.domain.usecase.order.GetOrderList
//import com.example.yumarketforowners.domain.usecase.order.UpdateOrderState
//import com.example.yumarketforowners.entity.createOrder
//import com.example.yumarketforowners.presentation.mapper.order.toOrderUiState
//import io.mockk.*
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.test.TestScope
//import kotlinx.coroutines.test.advanceUntilIdle
//import kotlinx.coroutines.test.runTest
//import org.junit.Before
//import org.junit.Test
//
//import org.junit.Rule
//import javax.inject.Provider
//
//@ExperimentalCoroutinesApi
//class OrderListPresenterTest {
//
//    @get:Rule
//    val testCoroutineRule = TestCoroutineRule()
//
//    private lateinit var sut: OrderListPresenter
//
//    // region test doubles =========================================================================
//    private lateinit var viewMock: OrderListInnerFragment
//    private lateinit var getOrderListMock: GetOrderList
//    private lateinit var scopeProviderMock: Provider<CoroutineScope>
//    private lateinit var updateOrderState: UpdateOrderState
//    // endregion test doubles ======================================================================
//
//    // region constants ============================================================================
//    private val testMarketId = 0L
//    // endregion constants =========================================================================
//
//    @Before
//    fun setup() {
//        viewMock = mockk(relaxed = true)
//        getOrderListMock = mockk()
//        scopeProviderMock = mockk()
//        updateOrderState = mockk(relaxUnitFun = true)
//
//        sut = OrderListPresenter(
//            view = viewMock,
////            getOrderList = getOrderListMock,
//            scopeProvider = scopeProviderMock,
//            updateOrderState = updateOrderState,
//            orderListFlow = flow {  }
//        )
//
//        every { scopeProviderMock.get() } returns TestScope()
//    }
//
//    @Test
//    fun `on request, show loading then hide when request complete`() = runTest {
//        // arrange
//        getOrderListReturns(orderState = OrderState.PENDING)
//
//        // act
//        sut.requestOrderList(marketId = testMarketId, orderState = OrderState.PENDING)
//        advanceUntilIdle()
//
//        // assert
//        verifyOrder {
//            viewMock.loading(isLoading = true)
//            viewMock.loading(isLoading = false)
//        }
//    }
//
//    @Test
//    fun `request pending order list, on success`() = runTest {
//        // arrange
//        val expected = getOrderListReturns(orderState = OrderState.PENDING)
//
//        // act
//        sut.requestOrderList(marketId = testMarketId, orderState = OrderState.PENDING)
//        advanceUntilIdle()
//
//        // assert
//        verify { viewMock.onRequestDataSuccess(expected) }
//    }
//
//    @Test
//    fun `request pending order list, on error`() = runTest {
//        // arrange
//        getOrderListFailed()
//
//        // act
//        sut.requestOrderList(marketId = testMarketId, orderState = OrderState.PENDING)
//        advanceUntilIdle()
//
//        // assert
//        verify { viewMock.onError(any()) }
//    }
//
//    @Test
//    fun `request accepted order list, on success`() = runTest {
//        // arrange
//        val expected = getOrderListReturns(orderState = OrderState.ACCEPTED)
//
//        // act
//        sut.requestOrderList(marketId = testMarketId, orderState = OrderState.ACCEPTED)
//        advanceUntilIdle()
//
//        // assert
//        verify { viewMock.onRequestDataSuccess(expected) }
//    }
//
//    @Test
//    fun `request accepted order list, on error`() = runTest {
//        // arrange
//        getOrderListFailed()
//
//        // act
//        sut.requestOrderList(marketId = testMarketId, orderState = OrderState.ACCEPTED)
//        advanceUntilIdle()
//
//        // assert
//        verify { viewMock.onError(any()) }
//    }
//
//    @Test
//    fun `request done order list, on success`() = runTest {
//        // arrange
//        val expected = getOrderListReturns(orderState = OrderState.DONE)
//
//        // act
//        sut.requestOrderList(marketId = testMarketId, orderState = OrderState.DONE)
//        advanceUntilIdle()
//
//        // assert
//        verify { viewMock.onRequestDataSuccess(expected) }
//    }
//
//    @Test
//    fun `request done order list, on error`() = runTest {
//        // arrange
//        getOrderListFailed()
//
//        // act
//        sut.requestOrderList(marketId = testMarketId, orderState = OrderState.DONE)
//        advanceUntilIdle()
//
//        // assert
//        verify { viewMock.onError(any()) }
//    }
//
//    // region helper methods =======================================================================
//
//    private fun getOrderListReturns(orderState: OrderState): List<OrderUiState> {
//        val returnValue = createOrderList(orderState)
//
//        coEvery {
//            getOrderListMock(marketId = any(), orderState = orderState)
//        } returns returnValue
//
//        return returnValue.map {
//            it.toOrderUiState(
//                onTelephoneNumberClicked = {},
//                onAcceptOrderButtonClicked = {},
//                onRejectOrderButtonClicked = {},
//                onDeliveryDoneButtonClicked = {}
//            )
//        }
//    }
//
//    private fun getOrderListFailed() {
//        coEvery { getOrderListMock(marketId = any(), orderState = any()) } returns null
//    }
//
//    private fun createOrderList(orderState: OrderState) = (1..10).map {
//        createOrder(it, orderState = orderState)
//    }
//
//    // endregion helper methods ====================================================================
//
//}