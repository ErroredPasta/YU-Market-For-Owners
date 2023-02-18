package com.example.yumarketforowners.orderlist.presentation.screen
//
//import com.example.yumarketforowners.core.TestCoroutineRule
//import com.example.yumarketforowners.orderlist.createOrder
//import com.example.yumarketforowners.orderlist.domain.model.OrderState
//import com.example.yumarketforowners.orderlist.domain.usecase.FakeOrderRepository
//import com.example.yumarketforowners.orderlist.domain.usecase.UpdateOrderStateUseCase
//import com.example.yumarketforowners.orderlist.presentation.mapper.toOrderUiState
//import com.example.yumarketforowners.orderlist.presentation.viewholder.OrderUiState
//import io.mockk.*
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.SupervisorJob
//import kotlinx.coroutines.plus
//import kotlinx.coroutines.test.TestScope
//import kotlinx.coroutines.test.advanceUntilIdle
//import kotlinx.coroutines.test.runTest
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
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
//    private lateinit var scopeProviderMock: Provider<CoroutineScope>
//    private lateinit var updateOrderStateUseCase: UpdateOrderStateUseCase
//    private lateinit var fakeOrderRepository: FakeOrderRepository
//    // endregion test doubles ======================================================================
//
//    @Before
//    fun setup() {
//        viewMock = mockk(relaxed = true)
//        scopeProviderMock = mockk()
//        updateOrderStateUseCase = mockk(relaxUnitFun = true)
//        fakeOrderRepository = FakeOrderRepository()
//
//        sut = OrderListPresenter(
//            view = viewMock,
//            scopeProvider = scopeProviderMock,
//            updateOrderStateUseCase = updateOrderStateUseCase,
//            orderListFlow = fakeOrderRepository.orderListFlow
//        )
//
//        every { scopeProviderMock.get() } returns TestScope() + SupervisorJob()
//    }
//
//    @Test
//    fun `on request, show loading then hide when request complete`() = runTest {
//        // arrange
//        getOrderListReturns(orderState = OrderState.PENDING)
//
//        // act
//        sut.observeOrderList(orderState = OrderState.PENDING)
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
//        sut.observeOrderList(orderState = OrderState.PENDING)
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
//        sut.observeOrderList(orderState = OrderState.PENDING)
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
//        sut.observeOrderList(orderState = OrderState.ACCEPTED)
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
//        sut.observeOrderList(orderState = OrderState.ACCEPTED)
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
//        sut.observeOrderList(orderState = OrderState.DONE)
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
//        sut.observeOrderList(orderState = OrderState.DONE)
//        advanceUntilIdle()
//
//        // assert
//        verify { viewMock.onError(any()) }
//    }
//
//    // region helper methods =======================================================================
//
//    private fun getOrderListReturns(orderState: OrderState): List<OrderUiState> =
//        createOrderList(orderState).map {
//            it.toOrderUiState(
//                onTelephoneNumberClicked = {},
//                onAcceptOrderButtonClicked = {},
//                onRejectOrderButtonClicked = {},
//                onDeliveryDoneButtonClicked = {}
//            )
//        }
//
//    private fun getOrderListFailed() {
//        fakeOrderRepository.getOrderListFailure = true
//    }
//
//    private fun createOrderList(orderState: OrderState) = (1..10).map {
//        createOrder(it, orderState = orderState)
//    }
//
//    // endregion helper methods ====================================================================
//
//}