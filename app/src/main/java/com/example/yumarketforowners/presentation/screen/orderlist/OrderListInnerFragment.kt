package com.example.yumarketforowners.presentation.screen.orderlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.os.bundleOf
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.presentation.recyclerview.listener.orderlist.OrderViewHolderListener
import com.example.yumarketforowners.databinding.InnerFragmentOrderListBinding
import com.example.yumarketforowners.domain.model.order.OrderState
import com.example.yumarketforowners.presentation.extension.addItemDivider
import com.example.yumarketforowners.presentation.screen.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OrderListInnerFragment :
    BaseFragment<InnerFragmentOrderListBinding>(), OrderListView {
    companion object {
        private const val ORDER_STATE_KEY = "ORDER_STATE_KEY"

        fun newInstance(orderState: OrderState) = OrderListInnerFragment().apply {
            arguments = bundleOf(ORDER_STATE_KEY to orderState)
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = InnerFragmentOrderListBinding.inflate(inflater, container, false)

    private val orderState by lazy {
        requireArguments()[ORDER_STATE_KEY] as OrderState
    }

    @Inject
    lateinit var presenter: OrderListPresenter

    private val adapter by lazy {
        ModelRecyclerAdapter<OrderUiState>(
            object : OrderViewHolderListener {
                override fun onTelePhoneNumberClicked(telephoneNumber: String) {
                    // TODO: 2022.06.09 start telephone screen with number
                    Toast.makeText(context, "$telephoneNumber clicked", Toast.LENGTH_SHORT).show()
                }

                override fun onAcceptOrderButtonClicked(order: OrderUiState) {
                    // TODO: 2022.06.09 handle accept order
                    Toast.makeText(context, "$order accept button clicked", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onRejectOrderButtonClicked(order: OrderUiState) {
                    // TODO: 2022.06.09 handle reject order
                    Toast.makeText(context, "$order reject button clicked", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onDeliveryDoneButtonClicked(order: OrderUiState) {
                    // TODO: 2022.06.09 handle delivery done
                    Toast.makeText(context, "$order done button clicked", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    override fun initState() {
        binding.orderListRecyclerView.apply {
            this.adapter = this@OrderListInnerFragment.adapter
            addItemDivider(LinearLayout.VERTICAL)
        }

        requestData()
    }

    private fun requestData() {
        // TODO: 2022.07.10 request data by market id
        presenter.requestData(marketId = 0, orderState = orderState)
    }

    override fun loading(isLoading: Boolean) {
        // TODO: 2022.07.10 implement loading
    }

    override fun onRequestDataSuccess(data: List<OrderUiState>) {
        adapter.submitList(data)
    }

    override fun onRequestDataError(@StringRes errorMessage: Int) {
        Toast.makeText(context, getText(errorMessage), Toast.LENGTH_SHORT).show()
    }
}