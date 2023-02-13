package com.example.yumarketforowners.orderlist.presentation.screen

import com.example.yumarketforowners.orderlist.domain.model.Order
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.example.yumarketforowners.orderlist.domain.usecase.UpdateOrderStateUseCase
import com.example.yumarketforowners.orderlist.presentation.mapper.toOrderUiState
import com.example.yumarketforowners.core.presentation.base.BaseCoroutinePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
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
        }.onStart {
            view.loading(isLoading = true)
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
        }.catch { cause ->
            view.onError(cause)
        }.onCompletion {
            view.loading(isLoading = false)
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