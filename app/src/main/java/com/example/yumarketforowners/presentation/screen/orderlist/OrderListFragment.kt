package com.example.yumarketforowners.presentation.screen.orderlist

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.yumarketforowners.databinding.FragmentOrderListBinding
import com.example.yumarketforowners.presentation.screen.base.BaseViewPagerFragment

class OrderListFragment :
    BaseViewPagerFragment<FragmentOrderListBinding, OrderListInnerFragment>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOrderListBinding = FragmentOrderListBinding.inflate(
        inflater, container, false
    )

    override val tabStrings = OrderState.values().map { it.tabString }

    override fun initState() {
        initViewPagerAndTabLayout(
            binding.orderListViewPager,
            binding.orderListTabLayout,
            OrderState.values().map(OrderListInnerFragment::newInstance)
        )
    }
}