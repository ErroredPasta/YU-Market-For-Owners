package com.example.yumarketforowners.presentation.screen.orderlist

import android.util.Log
import com.example.yumarketforowners.R
import com.example.yumarketforowners.di.qualifier.LifeCycleScope
import com.example.yumarketforowners.di.qualifier.LifeCycleScopeType.FRAGMENT
import com.example.yumarketforowners.domain.model.order.DeliveryType
import com.example.yumarketforowners.domain.model.order.OrderOptionGroup
import com.example.yumarketforowners.domain.model.order.OrderState
import com.example.yumarketforowners.domain.usecase.order.GetOrderList
import com.example.yumarketforowners.presentation.mapper.order.toOrderUiState
import com.example.yumarketforowners.presentation.screen.base.BaseCoroutinePresenter
import com.example.yumarketforowners.presentation.screen.base.BaseViewHolderState
import com.example.yumarketforowners.presentation.screen.base.Result
import com.example.yumarketforowners.presentation.viewholder.CellType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject
import javax.inject.Provider

class OrderListPresenter @Inject constructor(
    private val view: OrderListView,
    private val getOrderList: GetOrderList,
    @LifeCycleScope(FRAGMENT) scopeProvider: Provider<CoroutineScope>
) : BaseCoroutinePresenter(scopeProvider) {

    fun requestData(marketId: Long, orderState: OrderState) {
        coroutineScope.launch {
            view.loading(isLoading = true)
            /* TODO: 2022-09-21 수 01:34, error 처리 구현 */
            val result = getOrderList(marketId = marketId, orderState = orderState)?.let {
                Result.Success(
                    data = it.map { order ->
                        order.toOrderUiState(
                            onTelephoneNumberClicked = {
                                Log.d("TAG", "onTelephoneNumberClicked: ${order.id}")
                            },
                            onAcceptOrderButtonClicked = {
                                Log.d("TAG", "onAcceptOrderButtonClicked: ${order.id}")
                            },
                            onRejectOrderButtonClicked = {
                                Log.d("TAG", "onRejectOrderButtonClicked: ${order.id}")
                            },
                            onDeliveryDoneButtonClicked = {
                                Log.d("TAG", "onDeliveryDoneButtonClicked: ${order.id}")
                            }
                        )
                    }
                )
            } ?: Result.Error(R.string.error_placeholder)

            view.loading(isLoading = false)

            when (result) {
                is Result.Success -> view.onRequestDataSuccess(result.data)
                is Result.Error -> view.onRequestDataError(result.errorMessage)
            }
        }
    }

}

data class OrderUiState(
    override val id: Long,
    val orderId: String,
    val orderedAt: Long,
    val orderItems: List<OrderItemUiState>,
    val totalPrice: Int,
    val orderState: OrderState,
    val deliveryFee: Int,
    val deliveryTime: Pair<LocalTime, LocalTime>,
    val deliveryType: DeliveryType,
    val telephoneNumber: String,
    val request: String,
    val onTelephoneNumberClicked: () -> Unit,
    val onAcceptOrderButtonClicked: () -> Unit,
    val onRejectOrderButtonClicked: () -> Unit,
    val onDeliveryDoneButtonClicked: () -> Unit
) : BaseViewHolderState(id, CellType.ORDER_CELL)

data class OrderItemUiState(
    override val id: Long,
    val name: String,
    val imageUrl: String?,
    val amount: Int,
    val pricePerItem: Int,
    val orderOptionGroups: List<OrderOptionGroup>
) : BaseViewHolderState(id, CellType.ORDER_ITEM_CELL)