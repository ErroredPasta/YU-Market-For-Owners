package com.example.yumarketforowners.presentation.screen.orderlist

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.os.bundleOf
import com.example.yumarketforowners.presentation.adapter.ModelRecyclerAdapter
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

    private val adapter by lazy { ModelRecyclerAdapter<OrderUiState>() }

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

    override fun navigateToCallScreen(telephoneNumber: String) {
        startActivity(
            Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$telephoneNumber")
            }
        )
    }
}