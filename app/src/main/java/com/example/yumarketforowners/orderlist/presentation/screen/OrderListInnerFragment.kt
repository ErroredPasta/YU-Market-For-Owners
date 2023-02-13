package com.example.yumarketforowners.orderlist.presentation.screen

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import com.example.yumarketforowners.databinding.InnerFragmentOrderListBinding
import com.example.yumarketforowners.orderlist.domain.model.OrderState
import com.example.yumarketforowners.core.presentation.adapter.ModelRecyclerAdapter
import com.example.yumarketforowners.core.presentation.extension.addItemDivider
import com.example.yumarketforowners.core.presentation.base.BaseFragment
import com.example.yumarketforowners.orderlist.presentation.viewholder.OrderUiState
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
        checkNotNull(requireArguments()[ORDER_STATE_KEY]) {
            "orderState가 null입니다."
        } as OrderState
    }

    private var hasCallPhonePermission: Boolean = false
    private val callPhonePermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            hasCallPhonePermission = result
        }

    @Inject
    lateinit var presenter: OrderListPresenter

    private val adapter by lazy { ModelRecyclerAdapter<OrderUiState>() }

    override fun initState() {
        binding.orderListRecyclerView.apply {
            this.adapter = this@OrderListInnerFragment.adapter
            addItemDivider(LinearLayout.VERTICAL)
        }

//        presenter.requestOrderList(marketId = 0, orderState = orderState)
        presenter.observeOrderList(orderState = orderState)
    }


    override fun loading(isLoading: Boolean) {
        // TODO: 2022.07.10 implement loading
    }

    override fun onRequestDataSuccess(data: List<OrderUiState>) {
        adapter.submitList(data)
    }

    override fun onError(throwable: Throwable) {
        throwable.message?.let { showToast(message = it) }
    }

    override fun navigateToCallScreen(telephoneNumber: String) {
        if (hasCallPhonePermission) {
            startActivity(
                Intent(Intent.ACTION_CALL).apply {
                    data = Uri.parse("tel:$telephoneNumber")
                }
            )
        } else {
            callPhonePermissionLauncher.launch(Manifest.permission.CALL_PHONE)
        }
    }
}