package com.example.yumarketforowners.presentation.screen.orderlist

import com.example.yumarketforowners.domain.model.order.Order
import com.example.yumarketforowners.domain.model.order.OrderState
import com.example.yumarketforowners.domain.usecase.order.UpdateOrderStateUseCase
import com.example.yumarketforowners.presentation.mapper.order.toOrderUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Provider

class OrderListPresenter(
    private val view: OrderListView,
//    private val getOrderList: GetOrderList,
    private val updateOrderStateUseCase: UpdateOrderStateUseCase,
    private val orderListFlow: Flow<List<Order>>,
    scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(view, scopeProvider) {

    fun observeOrderList(orderState: OrderState) {
        orderListFlow.map {
            it.filter { order -> order.orderState == orderState }
        }.onEach {
            view.onRequestDataSuccess(
                it.map { order ->
                    order.toOrderUiState(
                        onTelephoneNumberClicked = {
                            view.navigateToCallScreen(order.telephoneNumber)
                        },
                        onAcceptOrderButtonClicked = {
                            coroutineScope.launch {
                                updateOrderStateUseCase(order.id, OrderState.ACCEPTED)
                            }
                        },
                        onRejectOrderButtonClicked = {
                            coroutineScope.launch {
                                updateOrderStateUseCase(order.id, OrderState.REJECTED)
                            }
                        },
                        onDeliveryDoneButtonClicked = {
                            coroutineScope.launch {
                                updateOrderStateUseCase(order.id, OrderState.DONE)
                            }
                        }
                    )
                }
            )
        }.launchIn(coroutineScope)
    }

    /* TODO: 2022-10-22 토 02:40, implement later */
//    fun requestOrderList(marketId: Long, orderState: OrderState) {
//        coroutineScope.launch(exceptionHandler) {
//            view.loading(isLoading = true)
//            /* TODO: 2022-09-21 수 01:34, error 처리 구현 */
//            val result = getOrderList(marketId = marketId, orderState = orderState).map { order ->
//                order.toOrderUiState(
//                    onTelephoneNumberClicked = {
//                        view.navigateToCallScreen(order.telephoneNumber)
//                    },
//                    onAcceptOrderButtonClicked = {
//                        coroutineScope.launch(exceptionHandler) {
//                            updateOrderState(order.id, OrderState.ACCEPTED)
//                        }
//                    },
//                    onRejectOrderButtonClicked = {
//                        coroutineScope.launch(exceptionHandler) {
//                            updateOrderState(order.id, OrderState.REJECTED)
//                        }
//                    },
//                    onDeliveryDoneButtonClicked = {
//                        coroutineScope.launch(exceptionHandler) {
//                            updateOrderState(order.id, OrderState.DONE)
//                        }
//                    }
//                )
//            }
//            view.loading(isLoading = false)
//
//            view.onRequestDataSuccess(result)
//        }
}